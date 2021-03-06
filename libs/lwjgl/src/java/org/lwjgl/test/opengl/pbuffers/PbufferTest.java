/*
 * Copyright (c) 2002-2004 LWJGL Project
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
package org.lwjgl.test.opengl.pbuffers;

import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.Pbuffer;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.opengl.glu.GLU;
import org.lwjgl.util.vector.Vector2f;

/**
 * $Id: PbufferTest.java,v 1.5 2005/05/04 20:59:39 cix_foo Exp $
 * <p/>
 * Tests Pbuffers
 *
 * @author elias_naur <elias_naur@users.sourceforge.net>
 * @version $Revision: 1.5 $
 */
public final class PbufferTest {

	/**
	 * Texture and pbuffer size
	 */
	private static final int TEXTURE_SIZE = 512;

	/**
	 * Size of the animated quad
	 */
	private static final int QUAD_SIZE = 64;

	/**
	 * The renderer to use when rendering to texture.
	 */
	private TextureRenderer texRenderer;

	/**
	 * Intended deiplay mode
	 */
	private DisplayMode mode;

	/**
	 * our quad moving around
	 */
	private Vector2f quadPosition;

	/**
	 * For positioning our quad in the texture
	 */
	private float texScaleX, texScaleY;

	/**
	 * our quadVelocity
	 */
	private Vector2f quadVelocity;

	/**
	 * angle of quad
	 */
	private float angle;

	/**
	 * degrees to rotate per frame
	 */
	private float angleRotation = 1.0f;

	/**
	 * Max speed of all changable attributes
	 */
	private static final float MAX_SPEED = 20.0f;

	/**
	 * The shared texture
	 */
	private static int texID;

	public PbufferTest(final int renderMode) {
		try {
			//find displaymode
			mode = findDisplayMode(800, 600, 16);
			Display.setDisplayMode(mode);
			Display.create(new PixelFormat(16, 0, 0, 0, 0));

			glInit();

			if ( (Pbuffer.getCapabilities() & Pbuffer.PBUFFER_SUPPORTED) == 0 ) {
				System.out.println("No Pbuffer support!");
				System.exit(-1);
			}
			System.out.println("Pbuffer support detected. Initializing...\n");

			switch ( renderMode ) {
				case 1:
					System.out.print("Creating pbuffer with unique context...");
					texRenderer = new UniqueRenderer(TEXTURE_SIZE, TEXTURE_SIZE, texID);
					break;
				case 2:
					System.out.print("Creating render-to-texture pbuffer with unique context...");
					texRenderer = new UniqueRendererRTT(TEXTURE_SIZE, TEXTURE_SIZE, texID);
					break;
			}

			System.out.println("OK");

			quadPosition = new Vector2f(100f, 100f);
			quadVelocity = new Vector2f(1.0f, 1.0f);

			texScaleX = TEXTURE_SIZE / (float)mode.getWidth();
	        texScaleY = TEXTURE_SIZE / (float)mode.getHeight();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Executes the test
	 */
	public void execute() {
		mainLoop();
		cleanup();
	}

	/**
	 * Runs the main loop of the "test"
	 */
	private void mainLoop() {
		while ( !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && !Display.isCloseRequested() ) {
			if ( Display.isVisible() ) {
				// check keyboard input
				processKeyboard();

				// do "game" logic, and render it
				logic();

				render();
			} else {
				// no need to render/paint if nothing has changed (ie. window dragged over)
				if ( Display.isDirty() )
					render();


				// don't waste cpu time, sleep more
				try {
					Thread.sleep(100);
				} catch (InterruptedException inte) {
				}
			}
			// Update window
			Display.update();
			// Sync
			Display.sync(100);
		}
	}

	/**
	 * Performs the logic
	 */
	private void logic() {
		angle += angleRotation;
		if ( angle > 360.0f )
			angle -= 360.0f;

		quadPosition.x += quadVelocity.x;
		quadPosition.y += quadVelocity.y;

		// check colision with vertical border border
		if ( quadPosition.x + QUAD_SIZE >= mode.getWidth() || quadPosition.x - QUAD_SIZE <= 0 )
			quadVelocity.x *= -1;

		// check collision with horizontal border
		if ( quadPosition.y + QUAD_SIZE >= mode.getHeight() || quadPosition.y - QUAD_SIZE <= 0 )
			quadVelocity.y *= -1;
	}

	private void render() {
		// -----------------------------------------------------------
		// -------------------- Pbuffer rendering --------------------
		// -----------------------------------------------------------
		// Tell the pbuffer to get ready for rendering
		texRenderer.enable();

		// Clear the background
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

		// Draw quad with gradient
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(quadPosition.x * texScaleX, quadPosition.y * texScaleY, 0);
			GL11.glRotatef(angle, 0.0f, 0.0f, 1.0f);
			GL11.glBegin(GL11.GL_QUADS);
			{
				GL11.glColor3f(1.0f, 0.0f, 0.0f);
				GL11.glVertex2i(-QUAD_SIZE, -QUAD_SIZE);
				GL11.glVertex2i(QUAD_SIZE, -QUAD_SIZE);
				GL11.glColor3f(0.0f, 0.0f, 1.0f);
				GL11.glVertex2i(QUAD_SIZE, QUAD_SIZE);
				GL11.glVertex2i(-QUAD_SIZE, QUAD_SIZE);
			}
			GL11.glEnd();
		}
		GL11.glPopMatrix();

		// Refresh the texture
		texRenderer.updateTexture();

		// -----------------------------------------------------------
		// -------------------- Display rendering --------------------
		// -----------------------------------------------------------
		try {
			Display.makeCurrent();
		} catch (LWJGLException e) {
			throw new RuntimeException(e);
		}

		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

		// draw white quad
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(quadPosition.x, quadPosition.y, 0);
			GL11.glRotatef(angle, 0.0f, 0.0f, 1.0f);
			GL11.glColor3f(1.0f, 1.0f, 1.0f);
			GL11.glBegin(GL11.GL_QUADS);
			{
				GL11.glTexCoord2f(0f, 0f);
				GL11.glVertex2i(-QUAD_SIZE, -QUAD_SIZE);
				GL11.glTexCoord2f(1f, 0f);
				GL11.glVertex2i(QUAD_SIZE, -QUAD_SIZE);
				GL11.glTexCoord2f(1f, 1f);
				GL11.glVertex2i(QUAD_SIZE, QUAD_SIZE);
				GL11.glTexCoord2f(0f, 1f);
				GL11.glVertex2i(-QUAD_SIZE, QUAD_SIZE);
			}
			GL11.glEnd();
		}
		GL11.glPopMatrix();
	}

	/**
	 * Processes keyboard input
	 */
	private void processKeyboard() {
		Keyboard.poll();

		//check for fullscreen key
		if ( Keyboard.isKeyDown(Keyboard.KEY_F) ) {
			try {
				Display.setDisplayMode(mode);
				Display.setFullscreen(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//check for window key
		if ( Keyboard.isKeyDown(Keyboard.KEY_W) ) {
			try {
				Display.setFullscreen(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//check for speed changes
		if ( Keyboard.isKeyDown(Keyboard.KEY_UP) )
			quadVelocity.y += 0.1f;
		if ( Keyboard.isKeyDown(Keyboard.KEY_DOWN) )
			quadVelocity.y -= 0.1f;
		if ( Keyboard.isKeyDown(Keyboard.KEY_RIGHT) )
			quadVelocity.x += 0.1f;
		if ( Keyboard.isKeyDown(Keyboard.KEY_LEFT) )
			quadVelocity.x -= 0.1f;

		if ( Keyboard.isKeyDown(Keyboard.KEY_ADD) )
			angleRotation += 0.1f;
		if ( Keyboard.isKeyDown(Keyboard.KEY_SUBTRACT) )
			angleRotation -= 0.1f;

		//throttle
		if ( quadVelocity.x < -MAX_SPEED )
			quadVelocity.x = -MAX_SPEED;
		if ( quadVelocity.x > MAX_SPEED )
			quadVelocity.x = MAX_SPEED;
		if ( quadVelocity.y < -MAX_SPEED )
			quadVelocity.y = -MAX_SPEED;
		if ( quadVelocity.y > MAX_SPEED )
			quadVelocity.y = MAX_SPEED;

		if ( angleRotation < 0.0f )
			angleRotation = 0.0f;
		if ( angleRotation > MAX_SPEED )
			angleRotation = MAX_SPEED;
	}

	/**
	 * Cleans up the test
	 */
	private void cleanup() {
		// Destroy texture
		IntBuffer buffer = BufferUtils.createIntBuffer(1);
		buffer.put(0, texID);
		GL11.glDeleteTextures(buffer);

		texRenderer.destroy();
		Display.destroy();
	}

	/**
	 * Retrieves a displaymode, if one such is available
	 *
	 * @param width  Required width
	 * @param height Required height
	 * @param bpp    Minimum required bits per pixel
	 *
	 * @return
	 */
	private DisplayMode findDisplayMode(int width, int height, int bpp) throws LWJGLException {
		DisplayMode[] modes = Display.getAvailableDisplayModes();
		for ( int i = 0; i < modes.length; i++ ) {
			if ( modes[i].getWidth() == width
			     && modes[i].getHeight() == height
			     && modes[i].getBitsPerPixel() >= bpp ) {
				return modes[i];
			}
		}
		return null;
	}

	static void initGLState(int width, int height, float color) {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GLU.gluOrtho2D(0, width, 0, height);

		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		GL11.glViewport(0, 0, width, height);

		//set clear color
		GL11.glClearColor(color, color, color, 0.0f);
	}

	/**
	 * Initializes OGL
	 */
	private void glInit() {
		// Sync frame (only works on windows)
		Display.setVSyncEnabled(true);

		// Create shared texture
		IntBuffer buffer = BufferUtils.createIntBuffer(1);
		GL11.glGenTextures(buffer);
		texID = buffer.get(0);

		GL11.glTexEnvf(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE, GL11.GL_MODULATE);
		GL11.glEnable(GL11.GL_TEXTURE_2D);

		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texID);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);

		initGLState(mode.getWidth(), mode.getHeight(), 0.0f);
	}

	/**
	 * Test entry point
	 */
	public static void main(String[] args) {
		if ( args.length != 1 )
			kill("Invalid arguments length.");

		int mode = -1;
		try {
			mode = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			kill("Invalid mode.");
		}

		if ( mode < 1 || mode > 4 )
			kill("Invalid mode.");

		System.out.println("Change between fullscreen and windowed mode, by pressing F and W respectively");
		System.out.println("Move quad using arrowkeys, and change rotation using +/-");

		PbufferTest test = new PbufferTest(mode);

		test.execute();
	}

	private static void kill(final String msg) {
		System.out.println(msg);
		System.out.println("-------");
		System.out.println("Usage: java org.lwjgl.test.opengl.pbuffer.PbufferTest <mode>");
		System.out.println("\n<mode>\tA number in the range 1-4.");
		System.out.println("\t1: no render-to-texture");
		System.out.println("\t2: with render-to-texture");

		System.exit(-1);
	}
}
