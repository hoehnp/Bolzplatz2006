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
package org.lwjgl.opengl;

import java.nio.ShortBuffer;

import org.lwjgl.util.generator.*;

public interface NV_half_float {
	/*
	 * Accepted by the <type> argument of VertexPointer, NormalPointer,
	 * ColorPointer, TexCoordPointer, FogCoordPointerEXT,
	 * SecondaryColorPointerEXT, VertexWeightPointerEXT, VertexAttribPointerNV,
	 * DrawPixels, ReadPixels, TexImage1D, TexImage2D, TexImage3D, TexSubImage1D,
	 * TexSubImage2D, TexSubImage3D, and GetTexImage:
	*/
	int GL_HALF_FLOAT_NV = 0x140B;

	void glVertex2hNV(@GLhalf short x, @GLhalf short y);

	void glVertex3hNV(@GLhalf short x, @GLhalf short y, @GLhalf short z);

	void glVertex4hNV(@GLhalf short x, @GLhalf short y, @GLhalf short z, @GLhalf short w);

	void glNormal3hNV(@GLhalf short nx, @GLhalf short ny, @GLhalf short nz);

	void glColor3hNV(@GLhalf short red, @GLhalf short green, @GLhalf short blue);

	void glColor4hNV(@GLhalf short red, @GLhalf short green, @GLhalf short blue, @GLhalf short alpha);

	void glTexCoord1hNV(@GLhalf short s);

	void glTexCoord2hNV(@GLhalf short s, @GLhalf short t);

	void glTexCoord3hNV(@GLhalf short s, @GLhalf short t, @GLhalf short r);

	void glTexCoord4hNV(@GLhalf short s, @GLhalf short t, @GLhalf short r, @GLhalf short q);

	void glMultiTexCoord1hNV(@GLenum int target, @GLhalf short s);

	void glMultiTexCoord2hNV(@GLenum int target, @GLhalf short s, @GLhalf short t);

	void glMultiTexCoord3hNV(@GLenum int target, @GLhalf short s, @GLhalf short t, @GLhalf short r);

	void glMultiTexCoord4hNV(@GLenum int target, @GLhalf short s, @GLhalf short t, @GLhalf short r, @GLhalf short q);

	void glFogCoordhNV(@GLhalf short fog);

	void glSecondaryColor3hNV(@GLhalf short red, @GLhalf short green, @GLhalf short blue);

	void glVertexAttrib1hNV(@GLuint int index, @GLhalf short x);

	void glVertexAttrib2hNV(@GLuint int index, @GLhalf short x, @GLhalf short y);

	void glVertexAttrib3hNV(@GLuint int index, @GLhalf short x, @GLhalf short y, @GLhalf short z);

	void glVertexAttrib4hNV(@GLuint int index, @GLhalf short x, @GLhalf short y, @GLhalf short z, @GLhalf short w);

	@StripPostfix("attribs")
	void glVertexAttribs1hvNV(@GLuint int index, @AutoSize("attribs") @GLsizei int n, @Const @GLhalf ShortBuffer attribs);
	@StripPostfix("attribs")
	void glVertexAttribs2hvNV(@GLuint int index, @AutoSize(value="attribs", expression=" >> 1") @GLsizei int n, @Const @GLhalf ShortBuffer attribs);
	@StripPostfix("attribs")
	void glVertexAttribs3hvNV(@GLuint int index, @AutoSize(value="attribs", expression=" / 3") @GLsizei int n, @Const @GLhalf ShortBuffer attribs);
	@StripPostfix("attribs")
	void glVertexAttribs4hvNV(@GLuint int index, @AutoSize(value="attribs", expression=" >> 2") @GLsizei int n, @Const @GLhalf ShortBuffer attribs);
}
