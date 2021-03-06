/* MACHINE GENERATED FILE, DO NOT EDIT */

#include <jni.h>
#include "extgl.h"

typedef void (APIENTRY *glGetQueryObjectuivPROC) (GLenum id, GLenum pname, GLuint * params);
typedef void (APIENTRY *glGetQueryObjectivPROC) (GLenum id, GLenum pname, GLint * params);
typedef void (APIENTRY *glGetQueryivPROC) (GLenum target, GLenum pname, GLint * params);
typedef void (APIENTRY *glEndQueryPROC) (GLenum target);
typedef void (APIENTRY *glBeginQueryPROC) (GLenum target, GLuint id);
typedef GLboolean (APIENTRY *glIsQueryPROC) (GLuint id);
typedef void (APIENTRY *glDeleteQueriesPROC) (GLsizei n, GLuint * ids);
typedef void (APIENTRY *glGenQueriesPROC) (GLsizei n, GLuint * ids);
typedef void (APIENTRY *glGetBufferPointervPROC) (GLenum target, GLenum pname, GLvoid ** pointer);
typedef void (APIENTRY *glGetBufferParameterivPROC) (GLenum target, GLenum pname, GLint * params);
typedef GLboolean (APIENTRY *glUnmapBufferPROC) (GLenum target);
typedef GLvoid * (APIENTRY *glMapBufferPROC) (GLenum target, GLenum access);
typedef void (APIENTRY *glGetBufferSubDataPROC) (GLenum target, GLintptr offset, GLsizeiptr size, GLvoid * data);
typedef void (APIENTRY *glBufferSubDataPROC) (GLenum target, GLintptr offset, GLsizeiptr size, const GLvoid * data);
typedef void (APIENTRY *glBufferDataPROC) (GLenum target, GLsizeiptr size, const GLvoid * data, GLenum usage);
typedef GLboolean (APIENTRY *glIsBufferPROC) (GLuint buffer);
typedef void (APIENTRY *glGenBuffersPROC) (GLsizei n, GLuint * buffers);
typedef void (APIENTRY *glDeleteBuffersPROC) (GLsizei n, const GLuint * buffers);
typedef void (APIENTRY *glBindBufferPROC) (GLenum target, GLuint buffer);

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL15_nglGetQueryObjectuiv(JNIEnv *env, jclass clazz, jint id, jint pname, jobject params, jint params_position, jlong function_pointer) {
	GLuint *params_address = ((GLuint *)(*env)->GetDirectBufferAddress(env, params)) + params_position;
	glGetQueryObjectuivPROC glGetQueryObjectuiv = (glGetQueryObjectuivPROC)((intptr_t)function_pointer);
	glGetQueryObjectuiv(id, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL15_nglGetQueryObjectiv(JNIEnv *env, jclass clazz, jint id, jint pname, jobject params, jint params_position, jlong function_pointer) {
	GLint *params_address = ((GLint *)(*env)->GetDirectBufferAddress(env, params)) + params_position;
	glGetQueryObjectivPROC glGetQueryObjectiv = (glGetQueryObjectivPROC)((intptr_t)function_pointer);
	glGetQueryObjectiv(id, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL15_nglGetQueryiv(JNIEnv *env, jclass clazz, jint target, jint pname, jobject params, jint params_position, jlong function_pointer) {
	GLint *params_address = ((GLint *)(*env)->GetDirectBufferAddress(env, params)) + params_position;
	glGetQueryivPROC glGetQueryiv = (glGetQueryivPROC)((intptr_t)function_pointer);
	glGetQueryiv(target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL15_nglEndQuery(JNIEnv *env, jclass clazz, jint target, jlong function_pointer) {
	glEndQueryPROC glEndQuery = (glEndQueryPROC)((intptr_t)function_pointer);
	glEndQuery(target);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL15_nglBeginQuery(JNIEnv *env, jclass clazz, jint target, jint id, jlong function_pointer) {
	glBeginQueryPROC glBeginQuery = (glBeginQueryPROC)((intptr_t)function_pointer);
	glBeginQuery(target, id);
}

JNIEXPORT jboolean JNICALL Java_org_lwjgl_opengl_GL15_nglIsQuery(JNIEnv *env, jclass clazz, jint id, jlong function_pointer) {
	glIsQueryPROC glIsQuery = (glIsQueryPROC)((intptr_t)function_pointer);
	GLboolean __result = glIsQuery(id);
	return __result;
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL15_nglDeleteQueries(JNIEnv *env, jclass clazz, jint n, jobject ids, jint ids_position, jlong function_pointer) {
	GLuint *ids_address = ((GLuint *)(*env)->GetDirectBufferAddress(env, ids)) + ids_position;
	glDeleteQueriesPROC glDeleteQueries = (glDeleteQueriesPROC)((intptr_t)function_pointer);
	glDeleteQueries(n, ids_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL15_nglGenQueries(JNIEnv *env, jclass clazz, jint n, jobject ids, jint ids_position, jlong function_pointer) {
	GLuint *ids_address = ((GLuint *)(*env)->GetDirectBufferAddress(env, ids)) + ids_position;
	glGenQueriesPROC glGenQueries = (glGenQueriesPROC)((intptr_t)function_pointer);
	glGenQueries(n, ids_address);
}

JNIEXPORT jobject JNICALL Java_org_lwjgl_opengl_GL15_nglGetBufferPointerv(JNIEnv *env, jclass clazz, jint target, jint pname, jint result_size, jlong function_pointer) {
	glGetBufferPointervPROC glGetBufferPointerv = (glGetBufferPointervPROC)((intptr_t)function_pointer);
	GLvoid * __result;
	glGetBufferPointerv(target, pname, &__result);
	return safeNewBuffer(env, __result, result_size);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL15_nglGetBufferParameteriv(JNIEnv *env, jclass clazz, jint target, jint pname, jobject params, jint params_position, jlong function_pointer) {
	GLint *params_address = ((GLint *)(*env)->GetDirectBufferAddress(env, params)) + params_position;
	glGetBufferParameterivPROC glGetBufferParameteriv = (glGetBufferParameterivPROC)((intptr_t)function_pointer);
	glGetBufferParameteriv(target, pname, params_address);
}

JNIEXPORT jboolean JNICALL Java_org_lwjgl_opengl_GL15_nglUnmapBuffer(JNIEnv *env, jclass clazz, jint target, jlong function_pointer) {
	glUnmapBufferPROC glUnmapBuffer = (glUnmapBufferPROC)((intptr_t)function_pointer);
	GLboolean __result = glUnmapBuffer(target);
	return __result;
}

JNIEXPORT jobject JNICALL Java_org_lwjgl_opengl_GL15_nglMapBuffer(JNIEnv *env, jclass clazz, jint target, jint access, jint result_size, jobject old_buffer, jlong function_pointer) {
	glMapBufferPROC glMapBuffer = (glMapBufferPROC)((intptr_t)function_pointer);
	GLvoid * __result = glMapBuffer(target, access);
	return safeNewBufferCached(env, __result, result_size, old_buffer);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL15_nglGetBufferSubData(JNIEnv *env, jclass clazz, jint target, jint offset, jint size, jobject data, jint data_position, jlong function_pointer) {
	GLvoid *data_address = ((GLvoid *)(((char *)(*env)->GetDirectBufferAddress(env, data)) + data_position));
	glGetBufferSubDataPROC glGetBufferSubData = (glGetBufferSubDataPROC)((intptr_t)function_pointer);
	glGetBufferSubData(target, offset, size, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL15_nglBufferSubData(JNIEnv *env, jclass clazz, jint target, jint offset, jint size, jobject data, jint data_position, jlong function_pointer) {
	const GLvoid *data_address = ((const GLvoid *)(((char *)(*env)->GetDirectBufferAddress(env, data)) + data_position));
	glBufferSubDataPROC glBufferSubData = (glBufferSubDataPROC)((intptr_t)function_pointer);
	glBufferSubData(target, offset, size, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL15_nglBufferData(JNIEnv *env, jclass clazz, jint target, jint size, jobject data, jint data_position, jint usage, jlong function_pointer) {
	const GLvoid *data_address = ((const GLvoid *)(((char *)safeGetBufferAddress(env, data)) + data_position));
	glBufferDataPROC glBufferData = (glBufferDataPROC)((intptr_t)function_pointer);
	glBufferData(target, size, data_address, usage);
}

JNIEXPORT jboolean JNICALL Java_org_lwjgl_opengl_GL15_nglIsBuffer(JNIEnv *env, jclass clazz, jint buffer, jlong function_pointer) {
	glIsBufferPROC glIsBuffer = (glIsBufferPROC)((intptr_t)function_pointer);
	GLboolean __result = glIsBuffer(buffer);
	return __result;
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL15_nglGenBuffers(JNIEnv *env, jclass clazz, jint n, jobject buffers, jint buffers_position, jlong function_pointer) {
	GLuint *buffers_address = ((GLuint *)(*env)->GetDirectBufferAddress(env, buffers)) + buffers_position;
	glGenBuffersPROC glGenBuffers = (glGenBuffersPROC)((intptr_t)function_pointer);
	glGenBuffers(n, buffers_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL15_nglDeleteBuffers(JNIEnv *env, jclass clazz, jint n, jobject buffers, jint buffers_position, jlong function_pointer) {
	const GLuint *buffers_address = ((const GLuint *)(*env)->GetDirectBufferAddress(env, buffers)) + buffers_position;
	glDeleteBuffersPROC glDeleteBuffers = (glDeleteBuffersPROC)((intptr_t)function_pointer);
	glDeleteBuffers(n, buffers_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL15_nglBindBuffer(JNIEnv *env, jclass clazz, jint target, jint buffer, jlong function_pointer) {
	glBindBufferPROC glBindBuffer = (glBindBufferPROC)((intptr_t)function_pointer);
	glBindBuffer(target, buffer);
}

