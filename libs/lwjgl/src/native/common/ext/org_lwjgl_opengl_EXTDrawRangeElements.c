/* MACHINE GENERATED FILE, DO NOT EDIT */

#include <jni.h>
#include "extgl.h"

typedef void (APIENTRY *glDrawRangeElementsEXTPROC) (GLenum mode, GLuint start, GLuint end, GLsizei count, GLenum type, const GLvoid * pIndices);

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDrawRangeElements_nglDrawRangeElementsEXT(JNIEnv *env, jclass clazz, jint mode, jint start, jint end, jint count, jint type, jobject pIndices, jint pIndices_position, jlong function_pointer) {
	const GLvoid *pIndices_address = ((const GLvoid *)(((char *)(*env)->GetDirectBufferAddress(env, pIndices)) + pIndices_position));
	glDrawRangeElementsEXTPROC glDrawRangeElementsEXT = (glDrawRangeElementsEXTPROC)((intptr_t)function_pointer);
	glDrawRangeElementsEXT(mode, start, end, count, type, pIndices_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDrawRangeElements_nglDrawRangeElementsEXTBO(JNIEnv *env, jclass clazz, jint mode, jint start, jint end, jint count, jint type, jint pIndices_buffer_offset, jlong function_pointer) {
	const GLvoid *pIndices_address = ((const GLvoid *)offsetToPointer(pIndices_buffer_offset));
	glDrawRangeElementsEXTPROC glDrawRangeElementsEXT = (glDrawRangeElementsEXTPROC)((intptr_t)function_pointer);
	glDrawRangeElementsEXT(mode, start, end, count, type, pIndices_address);
}

