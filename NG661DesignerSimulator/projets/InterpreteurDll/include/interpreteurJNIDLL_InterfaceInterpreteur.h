/*******************************************************************************
* Copyright (c) 2015, 2016 Thales.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* Contributors:
*    Thales Avionics - initial design and implementation
*******************************************************************************/

/* DO NOT EDIT THIS FILE - it is machine generated */
#include <QGLWidget>
#include <QTime>
#include "renderingengine.h"
#include "executeengine.h"
#include "pointer.h"

#include <jni.h>
/* Header for class interpreteurJNIDLL_InterfaceInterpreteur */

#ifndef _Included_interpreteurJNIDLL_InterfaceInterpreteur
#define _Included_interpreteurJNIDLL_InterfaceInterpreteur
#ifdef __cplusplus
extern "C" {
#endif


// Be careful, '_' character shall be present at the beginning of the methods

/*
 * Class:     interpreteurJNIDLL_InterfaceInterpreteur
 * Method:    createScene
 * Signature: (Ljava/lang/String;JII)Z
 */
JNIEXPORT jboolean JNICALL _Java_interpreteurJNIDLL_InterfaceInterpreteur_createScene
  (JNIEnv *, jobject, jstring, jlong, jint, jint);

/*
 * Class:     interpreteurJNIDLL_InterfaceInterpreteur
 * Method:    getObjectId
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL _Java_interpreteurJNIDLL_InterfaceInterpreteur_getObjectId
  (JNIEnv *, jobject);

/*
 * Class:     interpreteurJNIDLL_InterfaceInterpreteur
 * Method:    reloadScene
 * Signature: ()V
 */
JNIEXPORT void JNICALL _Java_interpreteurJNIDLL_InterfaceInterpreteur_reloadScene
  (JNIEnv *, jobject);

/*
 * Class:     interpreteurJNIDLL_InterfaceInterpreteur
 * Method:    drawScene
 * Signature: ()V
 */
JNIEXPORT void JNICALL _Java_interpreteurJNIDLL_InterfaceInterpreteur_drawScene
  (JNIEnv *, jobject, jlong);

/*
 * Class:     interpreteurJNIDLL_InterfaceInterpreteur
 * Method:    setSceneSize
 * Signature: (II)V
 */
JNIEXPORT void JNICALL _Java_interpreteurJNIDLL_InterfaceInterpreteur_setSceneSize
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     interpreteurJNIDLL_InterfaceInterpreteur
 * Method:    setResizeMode
 * Signature: (Z)V
 */
JNIEXPORT void JNICALL _Java_interpreteurJNIDLL_InterfaceInterpreteur_setResizeMode
  (JNIEnv *, jobject, jboolean);

/*
 * Class:     interpreteurJNIDLL_InterfaceInterpreteur
 * Method:    zoom
 * Signature: (D)V
 */
JNIEXPORT void JNICALL _Java_interpreteurJNIDLL_InterfaceInterpreteur_zoom
  (JNIEnv *, jobject, jdouble);

/*
 * Class:     interpreteurJNIDLL_InterfaceInterpreteur
 * Method:    pointerPressedEvent
 * Signature: (I)V
 */
JNIEXPORT void JNICALL _Java_interpreteurJNIDLL_InterfaceInterpreteur_pointerPressedEvent
  (JNIEnv *, jobject, jint);

/*
 * Class:     interpreteurJNIDLL_InterfaceInterpreteur
 * Method:    pointerReleasedEvent
 * Signature: (I)V
 */
JNIEXPORT void JNICALL _Java_interpreteurJNIDLL_InterfaceInterpreteur_pointerReleasedEvent
  (JNIEnv *, jobject, jint);

/*
 * Class:     interpreteurJNIDLL_InterfaceInterpreteur
 * Method:    pointerMovedEvent
 * Signature: (II)V
 */
JNIEXPORT void JNICALL _Java_interpreteurJNIDLL_InterfaceInterpreteur_pointerMovedEvent
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     interpreteurJNIDLL_InterfaceInterpreteur
 * Method:    keyboardPressedEvent
 * Signature: (I)V
 */
JNIEXPORT void JNICALL _Java_interpreteurJNIDLL_InterfaceInterpreteur_keyboardPressedEvent
  (JNIEnv *, jobject, jint);

/*
 * Class:     interpreteurJNIDLL_InterfaceInterpreteur
 * Method:    keyboardReleasedEvent
 * Signature: (I)V
 */
JNIEXPORT void JNICALL _Java_interpreteurJNIDLL_InterfaceInterpreteur_keyboardReleasedEvent
  (JNIEnv *, jobject, jint);

/*
 * Class:     interpreteurJNIDLL_InterfaceInterpreteur
 * Method:    wheelEvent
 * Signature: (I)V
 */
JNIEXPORT void JNICALL _Java_interpreteurJNIDLL_InterfaceInterpreteur_wheelEvent
  (JNIEnv *, jobject, jint);



#ifdef __cplusplus
}
#endif
#endif
