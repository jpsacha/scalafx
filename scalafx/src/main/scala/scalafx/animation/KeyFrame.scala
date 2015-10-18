/*
 * Copyright (c) 2011-2015, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package scalafx.animation

import javafx.{animation => jfxa, event => jfxe}

import scala.collection.JavaConversions._
import scala.language.implicitConversions
import scalafx.delegate.SFXDelegate
import scalafx.event.ActionEvent
import scalafx.util.Duration

/**
  * Companion Object for [[scalafx.animation.KeyFrame]].
  *
  * @define KF `KeyFrame`
  */
object KeyFrame {

  /**
    * Converts a ScalaFX $KF to a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/KeyFrame.html $KF]],
    * extracting its delegate.
    *
    * @param v ScalaFX $KF
    * @return JavaFX $KF extracted from `v`.
    */
  implicit def sfxKeyFrame2jfx(v: KeyFrame): jfxa.KeyFrame = if (v != null) v.delegate else null

  private def toJFXEventHandler[R](handler: ActionEvent => R): jfxe.EventHandler[jfxe.ActionEvent] =
    new jfxe.EventHandler[jfxe.ActionEvent] {
      override def handle(event: jfxe.ActionEvent): Unit = handler(new ActionEvent(event))

    }

  /**
    * Creates a new $KF instance
    *
    * @param time the time
    */
  def apply(time: Duration): KeyFrame = {
    new KeyFrame(new jfxa.KeyFrame(time))
  }

  /**
    * Creates a new $KF instance
    *
    * @param time the time
    * @param values a `Set` of [[scalafx.animation.KeyValue]] instances.
    */
  def apply(time: Duration,
            values: Set[_ <: KeyValue[_, _]]): KeyFrame = {
    val mappedValues: Seq[jfxa.KeyValue] = values.map((x: KeyValue[_, _]) => x.delegate).toSeq
    new KeyFrame(new jfxa.KeyFrame(time, mappedValues: _*))
  }

  /**
    * Creates a new $KF instance
    *
    * @param time the time
    * @param name the name.
    */
  def apply(time: Duration,
            name: String): KeyFrame = {
    new KeyFrame(new jfxa.KeyFrame(time, name))
  }

  /**
    * Creates a new $KF instance
    *
    * @param time the time
    * @param name the name.
    * @param values a `Set` of [[scalafx.animation.KeyValue]] instances.
    */
  def apply(time: Duration,
            name: String,
            values: Set[_ <: KeyValue[_, _]]): KeyFrame = {
    val mappedValues: Seq[jfxa.KeyValue] = values.map((x: KeyValue[_, _]) => x.delegate).toSeq
    new KeyFrame(new jfxa.KeyFrame(time, name, mappedValues: _*))
  }

  /**
    * Creates a new $KF instance
    *
    * @param time the time
    * @param onFinished the onFinished-handler.
    */
  def apply(time: Duration,
            onFinished: jfxe.EventHandler[jfxe.ActionEvent]): KeyFrame = {
    new KeyFrame(new jfxa.KeyFrame(time, onFinished))
  }

  /**
    * Creates a new $KF instance
    *
    * @param time the time
    * @param onFinished the onFinished-handler.
    * @param values a `Set` of [[scalafx.animation.KeyValue]] instances.
    */
  def apply(time: Duration,
            onFinished: jfxe.EventHandler[jfxe.ActionEvent],
            values: Set[_ <: KeyValue[_, _]]): KeyFrame = {
    val mappedValues: Seq[jfxa.KeyValue] = values.map((x: KeyValue[_, _]) => x.delegate).toSeq
    new KeyFrame(new jfxa.KeyFrame(time, onFinished, mappedValues: _*))
  }

  /**
    * Creates a new $KF instance
    *
    * @param time the time
    * @param onFinished the onFinished-handler.
    */
  def apply[R](time: Duration,
               onFinished: ActionEvent => R): KeyFrame = {
    new KeyFrame(new jfxa.KeyFrame(time, toJFXEventHandler(onFinished)))
  }

  /**
    * Creates a new $KF instance
    *
    * @param time the time
    * @param onFinished the onFinished-handler.
    */
  def apply[R](time: Duration,
               onFinished: ActionEvent => R,
               values: Set[_ <: KeyValue[_, _]]): KeyFrame = {
    val mappedValues: Seq[jfxa.KeyValue] = values.map((x: KeyValue[_, _]) => x.delegate).toSeq
    new KeyFrame(new jfxa.KeyFrame(time, toJFXEventHandler(onFinished), mappedValues: _*))
  }


  /**
    * Creates a new $KF instance
    *
    * @param time the time
    * @param name the name.
    * @param onFinished the onFinished-handler.
    */
  def apply(time: Duration,
            name: String,
            onFinished: jfxe.EventHandler[jfxe.ActionEvent]): KeyFrame = {
    new KeyFrame(new jfxa.KeyFrame(time, name, onFinished))
  }

  /**
    * Creates a new $KF instance
    *
    * @param time the time
    * @param name the name.
    * @param onFinished the onFinished-handler.
    * @param values a `Set` of [[scalafx.animation.KeyValue]] instances.
    */
  def apply(time: Duration,
            name: String,
            onFinished: jfxe.EventHandler[jfxe.ActionEvent],
            values: Set[_ <: KeyValue[_, _]]): KeyFrame = {
    val mappedValues: Set[jfxa.KeyValue] = values.map((x: KeyValue[_, _]) => x.delegate)
    new KeyFrame(new jfxa.KeyFrame(time, name, onFinished, mappedValues))
  }

  /**
    * Creates a new $KF instance
    *
    * @param time the time
    * @param name the name.
    * @param onFinished the onFinished-handler.
    */
  def apply[R](time: Duration,
               name: String,
               onFinished: ActionEvent => R): KeyFrame = {
    new KeyFrame(new jfxa.KeyFrame(time, name, toJFXEventHandler(onFinished)))
  }


  /**
    * Creates a new $KF instance
    *
    * @param time the time
    * @param name the name.
    * @param onFinished the onFinished-handler.
    * @param values a `Set` of [[scalafx.animation.KeyValue]] instances.
    */
  def apply[R](time: Duration,
               name: String,
               onFinished: ActionEvent => R,
               values: Set[_ <: KeyValue[_, _]]): KeyFrame = {
    val mappedValues: Set[jfxa.KeyValue] = values.map((x: KeyValue[_, _]) => x.delegate)
    new KeyFrame(new jfxa.KeyFrame(time, name, toJFXEventHandler(onFinished), mappedValues))
  }
}

/**
  * Wraps a [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/KeyFrame.html $KF]].
  *
  * @constructor Creates a new ScalaFX $KF from a JavaFX $KF.
  * @param delegate JavaFX $KF to be delegated.
  *
  * @define KF `KeyFrame`
  */
class KeyFrame(override val delegate: jfxa.KeyFrame)
  extends SFXDelegate[jfxa.KeyFrame] {

  /**
    * Returns the time offset of this $KF.
    */
  def time = new Duration(delegate.getTime)

  /**
    * Returns the name of this $KF.
    */
  def name = delegate.getName

  /**
    * Returns the onFinished event handler of this $KF.
    */
  def onFinished = delegate.getOnFinished

  /**
    * Returns an immutable Set of [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/KeyValue.html `KeyValue`]]
    * instances.
    */
  def values = delegate.getValues

}