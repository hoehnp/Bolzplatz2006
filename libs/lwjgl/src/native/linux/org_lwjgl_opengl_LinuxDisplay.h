/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_lwjgl_opengl_LinuxDisplay */

#ifndef _Included_org_lwjgl_opengl_LinuxDisplay
#define _Included_org_lwjgl_opengl_LinuxDisplay
#ifdef __cplusplus
extern "C" {
#endif
#undef org_lwjgl_opengl_LinuxDisplay_NUM_BUTTONS
#define org_lwjgl_opengl_LinuxDisplay_NUM_BUTTONS 3L
/* Inaccessible static: display_connection_usage_count */
/* Inaccessible static: peer_info */
/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    lockAWT
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_lockAWT
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    unlockAWT
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_unlockAWT
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    openDisplay
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_openDisplay
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    closeDisplay
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_closeDisplay
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nCreateWindow
 * Signature: (Ljava/nio/ByteBuffer;Lorg/lwjgl/opengl/DisplayMode;ZII)V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nCreateWindow
  (JNIEnv *, jclass, jobject, jobject, jboolean, jint, jint);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nDestroyWindow
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nDestroyWindow
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nSwitchDisplayMode
 * Signature: (Lorg/lwjgl/opengl/DisplayMode;)V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nSwitchDisplayMode
  (JNIEnv *, jclass, jobject);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nResetDisplayMode
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nResetDisplayMode
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nGetGammaRampLength
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nGetGammaRampLength
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nSetGammaRamp
 * Signature: (Ljava/nio/FloatBuffer;)V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nSetGammaRamp
  (JNIEnv *, jclass, jobject);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nInit
 * Signature: ()Lorg/lwjgl/opengl/DisplayMode;
 */
JNIEXPORT jobject JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nInit
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nSetTitle
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nSetTitle
  (JNIEnv *, jclass, jstring);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nIsCloseRequested
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nIsCloseRequested
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nIsVisible
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nIsVisible
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nIsActive
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nIsActive
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nIsDirty
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nIsDirty
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nUpdate
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nUpdate
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nReshape
 * Signature: (IIII)V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nReshape
  (JNIEnv *, jclass, jint, jint, jint, jint);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nGetAvailableDisplayModes
 * Signature: ()[Lorg/lwjgl/opengl/DisplayMode;
 */
JNIEXPORT jobjectArray JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nGetAvailableDisplayModes
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nCreateMouse
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nCreateMouse
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nDestroyMouse
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nDestroyMouse
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nPollMouse
 * Signature: (Ljava/nio/IntBuffer;Ljava/nio/ByteBuffer;)V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nPollMouse
  (JNIEnv *, jclass, jobject, jobject);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nReadMouse
 * Signature: (Ljava/nio/IntBuffer;I)I
 */
JNIEXPORT jint JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nReadMouse
  (JNIEnv *, jclass, jobject, jint);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nSetCursorPosition
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nSetCursorPosition
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nGrabMouse
 * Signature: (Z)V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nGrabMouse
  (JNIEnv *, jclass, jboolean);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nGetNativeCursorCapabilities
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nGetNativeCursorCapabilities
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nSetNativeCursor
 * Signature: (Ljava/lang/Object;)V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nSetNativeCursor
  (JNIEnv *, jclass, jobject);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nGetMinCursorSize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nGetMinCursorSize
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nGetMaxCursorSize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nGetMaxCursorSize
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nCreateKeyboard
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nCreateKeyboard
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nDestroyKeyboard
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nDestroyKeyboard
  (JNIEnv *, jclass);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nPollKeyboard
 * Signature: (Ljava/nio/ByteBuffer;)V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nPollKeyboard
  (JNIEnv *, jclass, jobject);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nReadKeyboard
 * Signature: (Ljava/nio/IntBuffer;I)I
 */
JNIEXPORT jint JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nReadKeyboard
  (JNIEnv *, jclass, jobject, jint);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nCreateCursor
 * Signature: (IIIIILjava/nio/IntBuffer;ILjava/nio/IntBuffer;I)Ljava/nio/ByteBuffer;
 */
JNIEXPORT jobject JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nCreateCursor
  (JNIEnv *, jclass, jint, jint, jint, jint, jint, jobject, jint, jobject, jint);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nDestroyCursor
 * Signature: (Ljava/lang/Object;)V
 */
JNIEXPORT void JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nDestroyCursor
  (JNIEnv *, jclass, jobject);

/*
 * Class:     org_lwjgl_opengl_LinuxDisplay
 * Method:    nGetPbufferCapabilities
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_lwjgl_opengl_LinuxDisplay_nGetPbufferCapabilities
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif
