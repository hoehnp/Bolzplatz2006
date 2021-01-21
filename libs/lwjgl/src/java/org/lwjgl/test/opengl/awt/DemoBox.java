/*
 * Copyright (c) 2002-2005 LWJGL Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'LWJGL' nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.lwjgl.test.opengl.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.FloatBuffer;
import java.util.Enumeration;
import java.util.Hashtable;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ARBTransposeMatrix;
import org.lwjgl.opengl.AWTGLCanvas;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

/**
 * $Id$
 * <p>
 * </p>
 * @version $Revision$
 * @author Brian Matzon <brian@matzon.dk>
 */
public class DemoBox extends Frame {

	/** GL canvas */
	private DemoBoxGLCanvas	demoCanvas;

	/** Demo selection panel */
	private Panel						selectionPanel;

	/** Hashtable of demos */
	private Hashtable				selectableDemos;

	/**
	 * Creates a new demo box instance
	 */
	public DemoBox() {
		selectableDemos = new Hashtable();
		selectableDemos.put("default", new NullDemoBox());
		selectableDemos.put("clear_color", new ClearColorDemoBox());
		selectableDemos.put("gears", new GearsDemoBox());
	}

	/**
	 * @return
	 */
	public boolean initialize() {
		setTitle("LWJGL - Demo Box");
		setSize(640, 480);
		setLayout(new GridBagLayout());

		// Setup selection panel
		// =================================
		selectionPanel = new Panel();
		selectionPanel.setLayout(new BorderLayout());
		selectionPanel.add(new Label("Demo", Label.CENTER), BorderLayout.NORTH);

		Button fullScreen = new Button("Fullscreen");
		fullScreen.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				toggleFullscreen();
			}
		});
		selectionPanel.add(fullScreen, BorderLayout.SOUTH);

		final List demos = new List();
		for (Enumeration e = selectableDemos.keys(); e.hasMoreElements();) {
			demos.add(e.nextElement().toString());
		}
		selectionPanel.add(demos, BorderLayout.CENTER);

		demos.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {
				demoSelected(event.getItemSelectable().getSelectedObjects()[0].toString());
			}
		});

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = java.awt.GridBagConstraints.BOTH;
		gbc.weightx = 0.05;
		gbc.weighty = 1.0;
		add(selectionPanel, gbc);
		// ---------------------------------

		// setup demo canvas
		// =================================
		try {
			demoCanvas = new DemoBoxGLCanvas(this);

			gbc = new GridBagConstraints();
			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.fill = java.awt.GridBagConstraints.BOTH;
			gbc.weightx = 0.95;
			gbc.weighty = 1.0;
			add(demoCanvas, gbc);
		} catch (LWJGLException le) {
			le.printStackTrace();
			return false;
		}
		// ---------------------------------

		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				demoCanvas.destroy();
				dispose();
			}
		});

		//demos.select(0);
		//demoSelected(demos.getSelectedItem());
		return true;
	}
	
	public void updateFPS(float fps) {
		if(fps != -1) {
			setTitle("LWJGL - Demo Box (FPS: " + fps + ")");
		} else {
			setTitle("LWJGL - Demo Box");
		}
	}

	/**
	 * Enter fullscreen mode for this demo
	 */
	protected void toggleFullscreen() {
		System.out.println("Toggle Fullscreen");
	}

	/**
	 * Selected a demo
	 * @param demo Name of demo that was selected
	 */
	protected void demoSelected(String demo) {
		System.out.println("Selecting demo: " + demo);
		demoCanvas.setActiveDemo((Demo) selectableDemos.get(demo));
	}

	/**
	 * @param args
	 * @throws LWJGLException
	 */
	public static void main(String[] args) throws LWJGLException {
		DemoBox demo = new DemoBox();
		demo.initialize();
		demo.setVisible(true);
	}

	/**
	 * Interface for a demo
	 */
	public interface Demo {
		public boolean isInitialized();
		public boolean initialize();
		public void render();
		public void destroy();
	}

	/**
	 * 
	 */
	private class DemoBoxGLCanvas extends AWTGLCanvas implements Runnable {

		/** Parent demo box */
		DemoBox parent;
		
		/** Currently active demo */
		Demo						activeDemo;

		/** last active demo */
		Demo						lastActiveDemo;

		/** Render thread */
		private Thread	renderThread;
		
		public DemoBoxGLCanvas(DemoBox parent) throws LWJGLException {
			super();
			this.parent = parent;			
		}

		// FPS
		long startTime = 0;
		long fps = 0;			

		protected void paintGL() {
			synchronized (this) {
				if (lastActiveDemo != null && lastActiveDemo != activeDemo) {
					lastActiveDemo.destroy();
					lastActiveDemo = null;
					if (activeDemo != null) {
						activeDemo.initialize();
						startTime = System.currentTimeMillis() + 5000;
					} else {
						parent.updateFPS(-1);
					}
				}
				
				if (activeDemo != null) {
					
					if(!activeDemo.isInitialized()) {
						activeDemo.initialize();
					}
					
					activeDemo.render();
					try {
						swapBuffers();
					} catch (LWJGLException le) {
						le.printStackTrace();
					}
					
					if (startTime > System.currentTimeMillis()) {
						fps++;
					} else {
						long timeUsed = 5000 + (startTime - System.currentTimeMillis());
						startTime = System.currentTimeMillis() + 5000;
						parent.updateFPS((fps / (timeUsed / 1000f)));
						fps = 0;
					}					
				}
			}
		}

		public void destroy() {
			setActiveDemo(null);
			renderThread = null;
		}

		public void setActiveDemo(Demo activeDemo) {
			synchronized (this) {
				// setting no current demo
				if (activeDemo == null) {
					lastActiveDemo = this.activeDemo;
					this.activeDemo = null;
					return;
				}

				// setting to new demo
				lastActiveDemo = this.activeDemo;
				this.activeDemo = activeDemo;
			}

			if (renderThread == null) {
				renderThread = new Thread(this);
				renderThread.setName("DemoBox-Renderer");
				renderThread.start();
			}
		}

		public DemoBoxGLCanvas() throws LWJGLException {
			super();
		}

		public void run() {
			long sleep_time = 1000;
			while (renderThread != null) {

				// check for change of demo
				synchronized (this) {
					// if no demo set, just sleep
					if (activeDemo == null) {
						sleep_time = 1000;
					} else {
						// we have a demo!
						sleep_time = 16;
						repaint();
					}
				}
				sleep(sleep_time);
			}
			System.out.println("dead");
		}

		private void sleep(long time) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException inte) {
			}
		}
	}

	// Demo box demo
	// ========================================================
	public class ClearColorDemoBox implements Demo {
		
		private boolean initialized;

		int		direction	= 1;

		float	color;
		
		public boolean isInitialized() {
			return initialized;
		}

		public boolean initialize() {
			return initialized = true;
		}

		public void render() {
			GL11.glClearColor(color, color, color, 1f);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

			color += direction * .05f;

			if (color > 1f) {
				color = 1f;
				direction = -1 * direction;
			} else if (color < 0f) {
				direction = -1 * direction;
				color = 0f;
			}
		}

		public void destroy() {
			initialized = false;
		}
	}

	// --------------------------------------------------------

	// Demo box demo
	// ========================================================
	public class NullDemoBox implements Demo {
		
		private boolean initialized;
		
		public boolean isInitialized() {
			return initialized;
		}

		public boolean initialize() {
			GL11.glClearColor(0, 0, 0, 1f);
			return true;
		}

		public void render() {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		}

		public void destroy() {
			initialized = false;
		}
	}
	// --------------------------------------------------------
	
	// Demo box demo
	// ========================================================
	public class GearsDemoBox implements Demo {
		
		private boolean initialized;
		
		private float	view_rotx	= 20.0f;

		private float	view_roty	= 30.0f;

		private float	view_rotz	= 0.0f;

		private int		gear1;

		private int		gear2;

		private int		gear3;

		private float	angle			= 0.0f;		
		
		public boolean isInitialized() {
			return initialized;
		}

		public boolean initialize() {
			//		 setup ogl
			FloatBuffer pos = BufferUtils.createFloatBuffer(4).put(new float[] { 5.0f, 5.0f, 10.0f, 0.0f});
			FloatBuffer red = BufferUtils.createFloatBuffer(4).put(new float[] { 0.8f, 0.1f, 0.0f, 1.0f});
			FloatBuffer green = BufferUtils.createFloatBuffer(4).put(new float[] { 0.0f, 0.8f, 0.2f, 1.0f});
			FloatBuffer blue = BufferUtils.createFloatBuffer(4).put(new float[] { 0.2f, 0.2f, 1.0f, 1.0f});
			pos.flip();
			red.flip();
			green.flip();
			blue.flip();
			
			GL11.glClearColor(0, 0, 0, 1f);

			GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, pos);
			GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_LIGHT0);
			GL11.glEnable(GL11.GL_DEPTH_TEST);

			/* make the gears */
			gear1 = GL11.glGenLists(1);
			GL11.glNewList(gear1, GL11.GL_COMPILE);
			GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, red);
			gear(1.0f, 4.0f, 1.0f, 20, 0.7f);
			GL11.glEndList();

			gear2 = GL11.glGenLists(1);
			GL11.glNewList(gear2, GL11.GL_COMPILE);
			GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, green);
			gear(0.5f, 2.0f, 2.0f, 10, 0.7f);
			GL11.glEndList();

			gear3 = GL11.glGenLists(1);
			GL11.glNewList(gear3, GL11.GL_COMPILE);
			GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, blue);
			gear(1.3f, 2.0f, 0.5f, 10, 0.7f);
			GL11.glEndList();

			GL11.glEnable(GL11.GL_NORMALIZE);

			GL11.glMatrixMode(GL11.GL_PROJECTION);

			System.err.println("GL_VENDOR: " + GL11.glGetString(GL11.GL_VENDOR));
			System.err.println("GL_RENDERER: " + GL11.glGetString(GL11.GL_RENDERER));
			System.err.println("GL_VERSION: " + GL11.glGetString(GL11.GL_VERSION));
			System.err.println();
			System.err.println("glLoadTransposeMatrixfARB() supported: " + GLContext.getCapabilities().GL_ARB_transpose_matrix);
			if (!GLContext.getCapabilities().GL_ARB_transpose_matrix) {
				// --- not using extensions
				GL11.glLoadIdentity();
			} else {
				// --- using extensions
				final FloatBuffer identityTranspose = BufferUtils.createFloatBuffer(16).put(
																																										new float[] { 1, 0, 0, 0, 0, 1, 0, 0,
																																												0, 0, 1, 0, 0, 0, 0, 1});
				identityTranspose.flip();
				ARBTransposeMatrix.glLoadTransposeMatrixARB(identityTranspose);
			}

			float h = (float) 300 / (float) 300;
			GL11.glFrustum(-1.0f, 1.0f, -h, h, 5.0f, 60.0f);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
			GL11.glTranslatef(0.0f, 0.0f, -40.0f);
			return initialized = true;
		}

		public void render() {
			angle += 2.0f;
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

			GL11.glPushMatrix();
			GL11.glRotatef(view_rotx, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(view_roty, 0.0f, 1.0f, 0.0f);
			GL11.glRotatef(view_rotz, 0.0f, 0.0f, 1.0f);

			GL11.glPushMatrix();
			GL11.glTranslatef(-3.0f, -2.0f, 0.0f);
			GL11.glRotatef(angle, 0.0f, 0.0f, 1.0f);
			GL11.glCallList(gear1);
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			GL11.glTranslatef(3.1f, -2.0f, 0.0f);
			GL11.glRotatef(-2.0f * angle - 9.0f, 0.0f, 0.0f, 1.0f);
			GL11.glCallList(gear2);
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			GL11.glTranslatef(-3.1f, 4.2f, 0.0f);
			GL11.glRotatef(-2.0f * angle - 25.0f, 0.0f, 0.0f, 1.0f);
			GL11.glCallList(gear3);
			GL11.glPopMatrix();

			GL11.glPopMatrix();
		}
		
		/**
		 * Draw a gear wheel.  You'll probably want to call this function when
		 * building a display list since we do a lot of trig here.
		 *
		 * @param inner_radius radius of hole at center
		 * @param outer_radius radius at center of teeth
		 * @param width width of gear
		 * @param teeth number of teeth
		 * @param tooth_depth depth of tooth
		 */
		private void gear(float inner_radius, float outer_radius, float width, int teeth, float tooth_depth) {
			int i;
			float r0, r1, r2;
			float angle, da;
			float u, v, len;

			r0 = inner_radius;
			r1 = outer_radius - tooth_depth / 2.0f;
			r2 = outer_radius + tooth_depth / 2.0f;

			da = 2.0f * (float) Math.PI / teeth / 4.0f;

			GL11.glShadeModel(GL11.GL_FLAT);

			GL11.glNormal3f(0.0f, 0.0f, 1.0f);

			/* draw front face */
			GL11.glBegin(GL11.GL_QUAD_STRIP);
			for (i = 0; i <= teeth; i++) {
				angle = i * 2.0f * (float) Math.PI / teeth;
				GL11.glVertex3f(r0 * (float) Math.cos(angle), r0 * (float) Math.sin(angle), width * 0.5f);
				GL11.glVertex3f(r1 * (float) Math.cos(angle), r1 * (float) Math.sin(angle), width * 0.5f);
				if (i < teeth) {
					GL11.glVertex3f(r0 * (float) Math.cos(angle), r0 * (float) Math.sin(angle), width * 0.5f);
					GL11.glVertex3f(r1 * (float) Math.cos(angle + 3.0f * da), r1 * (float) Math.sin(angle + 3.0f * da),
													width * 0.5f);
				}
			}
			GL11.glEnd();

			/* draw front sides of teeth */
			GL11.glBegin(GL11.GL_QUADS);
			for (i = 0; i < teeth; i++) {
				angle = i * 2.0f * (float) Math.PI / teeth;
				GL11.glVertex3f(r1 * (float) Math.cos(angle), r1 * (float) Math.sin(angle), width * 0.5f);
				GL11.glVertex3f(r2 * (float) Math.cos(angle + da), r2 * (float) Math.sin(angle + da), width * 0.5f);
				GL11.glVertex3f(r2 * (float) Math.cos(angle + 2.0f * da), r2 * (float) Math.sin(angle + 2.0f * da), width * 0.5f);
				GL11.glVertex3f(r1 * (float) Math.cos(angle + 3.0f * da), r1 * (float) Math.sin(angle + 3.0f * da), width * 0.5f);
			}
			GL11.glEnd();

			/* draw back face */
			GL11.glBegin(GL11.GL_QUAD_STRIP);
			for (i = 0; i <= teeth; i++) {
				angle = i * 2.0f * (float) Math.PI / teeth;
				GL11.glVertex3f(r1 * (float) Math.cos(angle), r1 * (float) Math.sin(angle), -width * 0.5f);
				GL11.glVertex3f(r0 * (float) Math.cos(angle), r0 * (float) Math.sin(angle), -width * 0.5f);
				GL11.glVertex3f(r1 * (float) Math.cos(angle + 3 * da), r1 * (float) Math.sin(angle + 3 * da), -width * 0.5f);
				GL11.glVertex3f(r0 * (float) Math.cos(angle), r0 * (float) Math.sin(angle), -width * 0.5f);
			}
			GL11.glEnd();

			/* draw back sides of teeth */
			GL11.glBegin(GL11.GL_QUADS);
			for (i = 0; i < teeth; i++) {
				angle = i * 2.0f * (float) Math.PI / teeth;
				GL11.glVertex3f(r1 * (float) Math.cos(angle + 3 * da), r1 * (float) Math.sin(angle + 3 * da), -width * 0.5f);
				GL11.glVertex3f(r2 * (float) Math.cos(angle + 2 * da), r2 * (float) Math.sin(angle + 2 * da), -width * 0.5f);
				GL11.glVertex3f(r2 * (float) Math.cos(angle + da), r2 * (float) Math.sin(angle + da), -width * 0.5f);
				GL11.glVertex3f(r1 * (float) Math.cos(angle), r1 * (float) Math.sin(angle), -width * 0.5f);
			}
			GL11.glEnd();

			/* draw outward faces of teeth */
			GL11.glBegin(GL11.GL_QUAD_STRIP);
			for (i = 0; i < teeth; i++) {
				angle = i * 2.0f * (float) Math.PI / teeth;
				GL11.glVertex3f(r1 * (float) Math.cos(angle), r1 * (float) Math.sin(angle), width * 0.5f);
				GL11.glVertex3f(r1 * (float) Math.cos(angle), r1 * (float) Math.sin(angle), -width * 0.5f);
				u = r2 * (float) Math.cos(angle + da) - r1 * (float) Math.cos(angle);
				v = r2 * (float) Math.sin(angle + da) - r1 * (float) Math.sin(angle);
				len = (float) Math.sqrt(u * u + v * v);
				u /= len;
				v /= len;
				GL11.glNormal3f(v, -u, 0.0f);
				GL11.glVertex3f(r2 * (float) Math.cos(angle + da), r2 * (float) Math.sin(angle + da), width * 0.5f);
				GL11.glVertex3f(r2 * (float) Math.cos(angle + da), r2 * (float) Math.sin(angle + da), -width * 0.5f);
				GL11.glNormal3f((float) Math.cos(angle), (float) Math.sin(angle), 0.0f);
				GL11.glVertex3f(r2 * (float) Math.cos(angle + 2 * da), r2 * (float) Math.sin(angle + 2 * da), width * 0.5f);
				GL11.glVertex3f(r2 * (float) Math.cos(angle + 2 * da), r2 * (float) Math.sin(angle + 2 * da), -width * 0.5f);
				u = r1 * (float) Math.cos(angle + 3 * da) - r2 * (float) Math.cos(angle + 2 * da);
				v = r1 * (float) Math.sin(angle + 3 * da) - r2 * (float) Math.sin(angle + 2 * da);
				GL11.glNormal3f(v, -u, 0.0f);
				GL11.glVertex3f(r1 * (float) Math.cos(angle + 3 * da), r1 * (float) Math.sin(angle + 3 * da), width * 0.5f);
				GL11.glVertex3f(r1 * (float) Math.cos(angle + 3 * da), r1 * (float) Math.sin(angle + 3 * da), -width * 0.5f);
				GL11.glNormal3f((float) Math.cos(angle), (float) Math.sin(angle), 0.0f);
			}
			GL11.glVertex3f(r1 * (float) Math.cos(0), r1 * (float) Math.sin(0), width * 0.5f);
			GL11.glVertex3f(r1 * (float) Math.cos(0), r1 * (float) Math.sin(0), -width * 0.5f);
			GL11.glEnd();

			GL11.glShadeModel(GL11.GL_SMOOTH);

			/* draw inside radius cylinder */
			GL11.glBegin(GL11.GL_QUAD_STRIP);
			for (i = 0; i <= teeth; i++) {
				angle = i * 2.0f * (float) Math.PI / teeth;
				GL11.glNormal3f(-(float) Math.cos(angle), -(float) Math.sin(angle), 0.0f);
				GL11.glVertex3f(r0 * (float) Math.cos(angle), r0 * (float) Math.sin(angle), -width * 0.5f);
				GL11.glVertex3f(r0 * (float) Math.cos(angle), r0 * (float) Math.sin(angle), width * 0.5f);
			}
			GL11.glEnd();
		}			

		public void destroy() {
			GL11.glDeleteLists(gear1, 1);
			GL11.glDeleteLists(gear2, 1);
			GL11.glDeleteLists(gear3, 1);
			initialized = false;
		}
	}
	// --------------------------------------------------------	
}
