/* MACHINE GENERATED FILE, DO NOT EDIT */

#include <jni.h>
#include "extgl.h"

typedef void (APIENTRY *glPointParameterfvEXTPROC) (GLenum pname, const GLfloat * pfParams);
typedef void (APIENTRY *glPointParameterfEXTPROC) (GLenum pname, GLfloat param);

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTPointParameters_nglPointParameterfvEXT(JNIEnv *env, jclass clazz, jint pname, jobject pfParams, jint pfParams_position, jlong function_pointer) {
	const GLfloat *pfParams_address = ((const GLfloat *)(*env)->GetDirectBufferAddress(env, pfParams)) + pfParams_position;
	glPointParameterfvEXTPROC glPointParameterfvEXT = (glPointParameterfvEXTPROC)((intptr_t)function_pointer);
	glPointParameterfvEXT(pname, pfParams_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTPointParameters_nglPointParameterfEXT(JNIEnv *env, jclass clazz, jint pname, jfloat param, jlong function_pointer) {
	glPointParameterfEXTPROC glPointParameterfEXT = (glPointParameterfEXTPROC)((intptr_t)function_pointer);
	glPointParameterfEXT(pname, param);
}

