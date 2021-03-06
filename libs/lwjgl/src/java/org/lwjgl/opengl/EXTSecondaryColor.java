/* MACHINE GENERATED FILE, DO NOT EDIT */

package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;
import org.lwjgl.BufferChecks;
import java.nio.*;

public final class EXTSecondaryColor {
	public static final int GL_SECONDARY_COLOR_ARRAY_EXT = 0x845e;
	public static final int GL_SECONDARY_COLOR_ARRAY_POINTER_EXT = 0x845d;
	public static final int GL_SECONDARY_COLOR_ARRAY_STRIDE_EXT = 0x845c;
	public static final int GL_SECONDARY_COLOR_ARRAY_TYPE_EXT = 0x845b;
	public static final int GL_SECONDARY_COLOR_ARRAY_SIZE_EXT = 0x845a;
	public static final int GL_CURRENT_SECONDARY_COLOR_EXT = 0x8459;
	public static final int GL_COLOR_SUM_EXT = 0x8458;

	private EXTSecondaryColor() {
	}


	public static void glSecondaryColorPointerEXT(int size, int stride, FloatBuffer pPointer) {
		long function_pointer = GLContext.getCapabilities().EXT_secondary_color_glSecondaryColorPointerEXT_pointer;
		BufferChecks.checkFunctionAddress(function_pointer);
		GLChecks.ensureArrayVBOdisabled();
		BufferChecks.checkDirect(pPointer);
		GLChecks.getReferences().EXT_secondary_color_glSecondaryColorPointerEXT_pPointer = pPointer;
		nglSecondaryColorPointerEXT(size, GL11.GL_FLOAT, stride, pPointer, pPointer.position() << 2, function_pointer);
	}
	public static void glSecondaryColorPointerEXT(int size, boolean unsigned, int stride, ByteBuffer pPointer) {
		long function_pointer = GLContext.getCapabilities().EXT_secondary_color_glSecondaryColorPointerEXT_pointer;
		BufferChecks.checkFunctionAddress(function_pointer);
		GLChecks.ensureArrayVBOdisabled();
		BufferChecks.checkDirect(pPointer);
		GLChecks.getReferences().EXT_secondary_color_glSecondaryColorPointerEXT_pPointer = pPointer;
		nglSecondaryColorPointerEXT(size, unsigned ? GL11.GL_UNSIGNED_BYTE : GL11.GL_BYTE, stride, pPointer, pPointer.position(), function_pointer);
	}
	private static native void nglSecondaryColorPointerEXT(int size, int type, int stride, Buffer pPointer, int pPointer_position, long function_pointer);
	public static void glSecondaryColorPointerEXT(int size, int type, int stride, int pPointer_buffer_offset) {
		long function_pointer = GLContext.getCapabilities().EXT_secondary_color_glSecondaryColorPointerEXT_pointer;
		BufferChecks.checkFunctionAddress(function_pointer);
		GLChecks.ensureArrayVBOenabled();
		nglSecondaryColorPointerEXTBO(size, type, stride, pPointer_buffer_offset, function_pointer);
	}
	private static native void nglSecondaryColorPointerEXTBO(int size, int type, int stride, int pPointer_buffer_offset, long function_pointer);

	public static void glSecondaryColor3ubEXT(byte red, byte green, byte blue) {
		long function_pointer = GLContext.getCapabilities().EXT_secondary_color_glSecondaryColor3ubEXT_pointer;
		BufferChecks.checkFunctionAddress(function_pointer);
		nglSecondaryColor3ubEXT(red, green, blue, function_pointer);
	}
	private static native void nglSecondaryColor3ubEXT(byte red, byte green, byte blue, long function_pointer);

	public static void glSecondaryColor3fEXT(float red, float green, float blue) {
		long function_pointer = GLContext.getCapabilities().EXT_secondary_color_glSecondaryColor3fEXT_pointer;
		BufferChecks.checkFunctionAddress(function_pointer);
		nglSecondaryColor3fEXT(red, green, blue, function_pointer);
	}
	private static native void nglSecondaryColor3fEXT(float red, float green, float blue, long function_pointer);

	public static void glSecondaryColor3bEXT(byte red, byte green, byte blue) {
		long function_pointer = GLContext.getCapabilities().EXT_secondary_color_glSecondaryColor3bEXT_pointer;
		BufferChecks.checkFunctionAddress(function_pointer);
		nglSecondaryColor3bEXT(red, green, blue, function_pointer);
	}
	private static native void nglSecondaryColor3bEXT(byte red, byte green, byte blue, long function_pointer);
}
