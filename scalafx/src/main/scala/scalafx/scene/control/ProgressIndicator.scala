/*
 * Copyright (c) 2011-2014, ScalaFX Project
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
package scalafx.scene.control

import javafx.scene.{control => jfxsc}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property.{DoubleProperty, ReadOnlyBooleanProperty}
import scalafx.delegate.SFXDelegate

object ProgressIndicator {
  implicit def sfxProgressIndicator2jfx(v: ProgressIndicator): jfxsc.ProgressIndicator = if (v != null) v.delegate else null

  val INDETERMINATE_PROGRESS = jfxsc.ProgressIndicator.INDETERMINATE_PROGRESS
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/ProgressIndicator.html]]
 */
class ProgressIndicator(override val delegate: jfxsc.ProgressIndicator = new jfxsc.ProgressIndicator)
  extends Control(delegate)
  with SFXDelegate[jfxsc.ProgressIndicator] {

  /**
   * A flag indicating whether it is possible to determine the progress of the ProgressIndicator.
   */
  def indeterminate: ReadOnlyBooleanProperty = delegate.indeterminateProperty

  /**
   * The actual progress of the ProgressIndicator.
   */
  def progress: DoubleProperty = delegate.progressProperty
  def progress_=(v: Double) {
    progress() = v
  }

}