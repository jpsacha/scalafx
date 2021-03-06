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
package scalafx.scene

import javafx.scene.{effect => jfxse, input => jfxsi, layout => jfxsl, transform => jfxst}
import javafx.{event => jfxe, geometry => jfxg, scene => jfxs, util => jfxu}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, DoubleProperty, ObjectProperty, ReadOnlyBooleanProperty, ReadOnlyObjectProperty, StringProperty}
import scalafx.collections._
import scalafx.delegate.SFXDelegate
import scalafx.event.Event._
import scalafx.event.{Event, EventHandlerDelegate}
import scalafx.geometry.Bounds._
import scalafx.geometry.Point2D._
import scalafx.geometry.{Bounds, Insets, Point2D, Point3D, Pos}
import scalafx.scene.effect.{BlendMode, Effect}
import scalafx.scene.image.WritableImage
import scalafx.scene.layout.Priority
import scalafx.scene.transform.Transform

object Node {
  implicit def sfxNode2jfx(v: Node): jfxs.Node = if (v != null) v.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/Node.html]].
 */
abstract class Node protected(override val delegate: jfxs.Node)
  extends EventHandlerDelegate
  with SFXDelegate[jfxs.Node] {

  /**
   * The BlendMode used to blend this individual node into the scene behind it.
   */
  def blendMode: ObjectProperty[jfxse.BlendMode] = delegate.blendModeProperty

  def blendMode_=(v: BlendMode) {
    blendMode() = v
  }

  /**
   * The rectangular bounds of this Node in the node's untransformed local coordinate space.
   */
  def boundsInLocal: ReadOnlyObjectProperty[jfxg.Bounds] = delegate.boundsInLocalProperty

  /**
   * The rectangular bounds of this Node which include its transforms.
   */
  def boundsInParent: ReadOnlyObjectProperty[jfxg.Bounds] = delegate.boundsInParentProperty

  /**
   * Additional hint for controlling bitmap caching.
   */
  def cacheHint: ObjectProperty[jfxs.CacheHint] = delegate.cacheHintProperty

  def cacheHint_=(v: CacheHint) {
    cacheHint() = v
  }

  /**
   * A performance hint to the system to indicate that this Node should be cached as a bitmap.
   */
  def cache: BooleanProperty = delegate.cacheProperty

  def cache_=(v: Boolean) {
    cache() = v
  }

  /**
   * Specifies a Node to use to define the the clipping shape for this Node.
   */
  def clip: ObjectProperty[jfxs.Node] = delegate.clipProperty

  def clip_=(v: Node) {
    clip() = v
  }

  /**
   * Defines the mouse cursor for this Node and subnodes.
   */
  def cursor: ObjectProperty[jfxs.Cursor] = delegate.cursorProperty

  def cursor_=(v: Cursor) {
    cursor() = v
  }

  /**
   * Indicates whether depth testing is used when rendering this node.
   */
  def depthTest: ObjectProperty[jfxs.DepthTest] = delegate.depthTestProperty

  def depthTest_=(v: DepthTest) {
    depthTest() = v
  }

  /**
   * Indicates whether or not this Node is disabled.
   */
  def disabled: ReadOnlyBooleanProperty = delegate.disabledProperty

  /**
   * Sets the individual disabled state of this Node.
   */
  def disable: BooleanProperty = delegate.disableProperty

  def disable_=(v: Boolean) {
    disable() = v
  }

  /**
   * Specifies an effect to apply to this Node.
   */
  def effect: ObjectProperty[jfxse.Effect] = delegate.effectProperty

  def effect_=(v: Effect) {
    ObjectProperty.fillProperty[jfxse.Effect](this.effect, v)
  }

  /**
   * Specifies the event dispatcher for this node.
   */
  def eventDispatcher: ObjectProperty[jfxe.EventDispatcher] = delegate.eventDispatcherProperty

  def eventDispatcher_=(v: jfxe.EventDispatcher) {
    eventDispatcher() = v
  }

  /**
   * Indicates whether this Node currently has the input focus.
   */
  def focused: ReadOnlyBooleanProperty = delegate.focusedProperty

  /**
   * Specifies whether this Node should be a part of focus traversal cycle.
   */
  def focusTraversable: BooleanProperty = delegate.focusTraversableProperty

  def focusTraversable_=(v: Boolean) {
    focusTraversable() = v
  }

  /**
   * Whether or not this Node is being hovered over.
   */
  def hover: ReadOnlyBooleanProperty = delegate.hoverProperty

  /**
   * The id of this Node.
   */
  def id: StringProperty = delegate.idProperty

  def id_=(v: String) {
    id() = v
  }

  /**
   * Property holding InputMethodRequests.
   */
  def inputMethodRequests: ObjectProperty[jfxsi.InputMethodRequests] = delegate.inputMethodRequestsProperty

  def inputMethodRequests_=(v: jfxsi.InputMethodRequests) {
    inputMethodRequests() = v
  }

  /**
   * The rectangular bounds that should be used for layout calculations for this node.
   */
  def layoutBounds: ReadOnlyObjectProperty[jfxg.Bounds] = delegate.layoutBoundsProperty

  /**
   * Defines the x coordinate of the translation that is added to this Node's transform for the
   * purpose of layout.
   */
  def layoutX: DoubleProperty = delegate.layoutXProperty

  def layoutX_=(v: Double) {
    layoutX() = v
  }

  /**
   * Defines the y coordinate of the translation that is added to this Node's transform for the
   * purpose of layout.
   */
  def layoutY: DoubleProperty = delegate.layoutYProperty

  def layoutY_=(v: Double) {
    layoutY() = v
  }

  /**
   * Defines whether or not this node's layout will be managed by it's parent.
   */
  def managed: BooleanProperty = delegate.managedProperty

  def managed_=(v: Boolean) {
    managed() = v
  }

  /**
   * If true, this node (together with all its children) is completely transparent to mouse events.
   */
  def mouseTransparent: BooleanProperty = delegate.mouseTransparentProperty

  def mouseTransparent_=(v: Boolean) {
    mouseTransparent() = v
  }

  /**
   * Defines a function to be called when a context menu has been requested on this Node.
   */
  def onContextMenuRequested = delegate.onContextMenuRequestedProperty

  def onContextMenuRequested_=(v: jfxe.EventHandler[_ >: jfxsi.ContextMenuEvent]) {
    onContextMenuRequested() = v
  }

  /**
   * Defines a function to be called when drag gesture has been detected.
   */
  def onDragDetected = delegate.onDragDetectedProperty

  def onDragDetected_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onDragDetected() = v
  }

  /**
   * Defines a function to be called when this Node is a drag and drop gesture source after its
   * data has been dropped on a drop target.
   */
  def onDragDone = delegate.onDragDoneProperty

  def onDragDone_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragDone() = v
  }

  /**
   * Defines a function to be called when the mouse button is released on this Node during drag
   * and drop gesture.
   */
  def onDragDropped = delegate.onDragDroppedProperty

  def onDragDropped_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragDropped() = v
  }

  /**
   * Defines a function to be called when drag gesture enters this Node.
   */
  def onDragEntered = delegate.onDragEnteredProperty

  def onDragEntered_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragEntered() = v
  }

  /**
   * Defines a function to be called when drag gesture exits this Node.
   */
  def onDragExited = delegate.onDragExitedProperty

  def onDragExited_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragExited() = v
  }

  /**
   * Defines a function to be called when drag gesture progresses within this Node.
   */
  def onDragOver = delegate.onDragOverProperty

  def onDragOver_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragOver() = v
  }

  /**
   * Defines a function to be called when this Node has input focus and the input method text has
   * changed.
   */
  def onInputMethodTextChanged = delegate.onInputMethodTextChangedProperty

  def onInputMethodTextChanged_=(v: jfxe.EventHandler[_ >: jfxsi.InputMethodEvent]) {
    onInputMethodTextChanged() = v
  }

  /**
   * Defines a function to be called when this Node or its child Node has input focus and a key
   * has been pressed.
   */
  def onKeyPressed = delegate.onKeyPressedProperty

  def onKeyPressed_=(v: jfxe.EventHandler[_ >: jfxsi.KeyEvent]) {
    onKeyPressed() = v
  }

  /**
   * Defines a function to be called when this Node or its child Node has input focus and a key
   * has been released.
   */
  def onKeyReleased = delegate.onKeyReleasedProperty

  def onKeyReleased_=(v: jfxe.EventHandler[_ >: jfxsi.KeyEvent]) {
    onKeyReleased() = v
  }

  /**
   * Defines a function to be called when this Node or its child Node has input focus and a key
   * has been typed.
   */
  def onKeyTyped = delegate.onKeyTypedProperty

  def onKeyTyped_=(v: jfxe.EventHandler[_ >: jfxsi.KeyEvent]) {
    onKeyTyped() = v
  }

  /**
   * Defines a function to be called when a mouse button has been clicked (pressed and released)
   * on this Node.
   */
  def onMouseClicked = delegate.onMouseClickedProperty

  def onMouseClicked_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseClicked() = v
  }

  /**
   * Defines a function to be called when a mouse button is pressed on this Node and then dragged.
   */
  def onMouseDragged = delegate.onMouseDraggedProperty

  def onMouseDragged_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseDragged() = v
  }

  /**
   * Defines a function to be called when a full press-drag-release gesture enters this Node.
   */
  def onMouseDragEntered = delegate.onMouseDragEnteredProperty

  def onMouseDragEntered_=(v: jfxe.EventHandler[_ >: jfxsi.MouseDragEvent]) {
    onMouseDragEntered() = v
  }

  /**
   * Defines a function to be called when a full press-drag-release gesture leaves this Node.
   */
  def onMouseDragExited = delegate.onMouseDragExitedProperty

  def onMouseDragExited_=(v: jfxe.EventHandler[_ >: jfxsi.MouseDragEvent]) {
    onMouseDragExited() = v
  }

  /**
   * Defines a function to be called when a full press-drag-release gesture progresses within this Node.
   */
  def onMouseDragOver = delegate.onMouseDragOverProperty

  def onMouseDragOver_=(v: jfxe.EventHandler[_ >: jfxsi.MouseDragEvent]) {
    onMouseDragOver() = v
  }

  /**
   * Defines a function to be called when a full press-drag-release gesture ends (by releasing mouse button) within 
   * this Node.
   */
  def onMouseDragReleased = delegate.onMouseDragReleasedProperty

  def onMouseDragReleased_=(v: jfxe.EventHandler[_ >: jfxsi.MouseDragEvent]) {
    onMouseDragReleased() = v
  }

  /**
   * Defines a function to be called when the mouse enters this Node.
   */
  def onMouseEntered = delegate.onMouseEnteredProperty

  def onMouseEntered_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseEntered() = v
  }

  /**
   * Defines a function to be called when the mouse exits this Node.
   */
  def onMouseExited = delegate.onMouseExitedProperty

  def onMouseExited_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseExited() = v
  }

  def onMouseMoved = delegate.onMouseMovedProperty

  def onMouseMoved_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseMoved() = v
  }

  /**
   * Defines a function to be called when a mouse button has been pressed on this Node.
   */
  def onMousePressed = delegate.onMousePressedProperty

  def onMousePressed_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMousePressed() = v
  }

  /**
   * Defines a function to be called when a mouse button has been released on this Node.
   */
  def onMouseReleased = delegate.onMouseReleasedProperty

  def onMouseReleased_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseReleased() = v
  }

  /**
   * Defines a function to be called when user performs a scrolling action.
   */
  def onScroll = delegate.onScrollProperty

  def onScroll_=(v: jfxe.EventHandler[_ >: jfxsi.ScrollEvent]) {
    onScroll() = v
  }

  /**
   * Specifies how opaque (that is, solid) the Node appears.
   */
  def opacity: DoubleProperty = delegate.opacityProperty

  def opacity_=(v: Double) {
    opacity() = v
  }

  /**
   * The parent of this Node.
   */
  def parent: ReadOnlyObjectProperty[jfxs.Parent] = delegate.parentProperty

  /**
   * Defines how the picking computation is done for this node when triggered by a MouseEvent or a
   * contains function call.
   */
  def pickOnBounds: BooleanProperty = delegate.pickOnBoundsProperty

  def pickOnBounds_=(v: Boolean) {
    pickOnBounds() = v
  }

  /**
   * Whether or not the Node is pressed.
   */
  def pressed: ReadOnlyBooleanProperty = delegate.pressedProperty

  /**
   * Defines the angle of rotation about the Node's center, measured in degrees.
   */
  def rotate: DoubleProperty = delegate.rotateProperty

  def rotate_=(v: Double) {
    rotate() = v
  }

  /**
   * Defines the axis of rotation of this Node.
   */
  def rotationAxis: ObjectProperty[jfxg.Point3D] = delegate.rotationAxisProperty

  def rotationAxis_=(v: Point3D) {
    rotationAxis() = v
  }

  /**
   * Defines the factor by which coordinates are scaled about the center of the object along
   * the X axis of this Node.
   */
  def scaleX: DoubleProperty = delegate.scaleXProperty

  def scaleX_=(v: Double) {
    scaleX() = v
  }

  /**
   * Defines the factor by which coordinates are scaled about the center of the object along the
   * Y axis of this Node.
   */
  def scaleY: DoubleProperty = delegate.scaleYProperty

  def scaleY_=(v: Double) {
    scaleY() = v
  }

  /**
   * Defines the factor by which coordinates are scaled about the center of the object along the
   * Z axis of this Node.
   */
  def scaleZ: DoubleProperty = delegate.scaleZProperty

  def scaleZ_=(v: Double) {
    scaleZ() = v
  }

  /**
   * The Scene that this Node is part of.
   */
  def scene: ReadOnlyObjectProperty[jfxs.Scene] = delegate.sceneProperty

  /**
   * A string representation of the CSS style associated with this specific Node.
   */
  def style: StringProperty = delegate.styleProperty

  def style_=(v: String) {
    style() = v
  }

  /**
   * CSS styles classes used by this Node.
   */
  def styleClass = delegate.getStyleClass
  /**
   * Sets the list of CSS styles classes, replacing the prior content. If you want append to current content, use `add`
   * or similar.
   *
   * @param c list of CSS styles classes to replace prior content.
   */
  def styleClass_=(c: Iterable[String]) {
    fillCollection(styleClass, c)
  }

  /**
   * Defines the ObservableList of Transform objects to be applied to this Node.
   */
  def transforms = delegate.getTransforms
  /**
   * Sets the list of transforms, replacing the prior content. If you want append to current content, use `add` or
   * similar.
   *
   * @param c list of transforms to replace prior content.
   */
  def transforms_=(c: Iterable[Transform]) {
    fillSFXCollection(transforms, c)
  }

  /**
   * Defines the x coordinate of the translation that is added to this Node's transform.
   */
  def translateX: DoubleProperty = delegate.translateXProperty

  def translateX_=(v: Double) {
    translateX() = v
  }

  /**
   * Defines the y coordinate of the translation that is added to this Node's transform.
   */
  def translateY: DoubleProperty = delegate.translateYProperty

  def translateY_=(v: Double) {
    translateY() = v
  }

  /**
   * Defines the Z coordinate of the translation that is added to the transformed coordinates of
   * this Node.
   */
  def translateZ: DoubleProperty = delegate.translateZProperty

  def translateZ_=(v: Double) {
    translateZ() = v
  }

  /**
   * Returns a previously set Object property, or null if no such property has been set using the
   * setUserData(AnyRef) method.
   */
  def userData = delegate.getUserData

  def userData_=(v: AnyRef) {
    delegate.setUserData(v)
  }

  /**
   * Specifies whether this Node and any subnodes should be rendered as part of the scene graph.
   */
  def visible: BooleanProperty = delegate.visibleProperty

  def visible_=(v: Boolean) {
    visible() = v
  }

  // layout pseudo-properties:

  /**
   * Pseudo-property that indicates this Node position inside its respective parent.
   */
  def alignmentInParent: Pos = delegate.getProperties.get("alignment").asInstanceOf[jfxg.Pos]

  /**
   * Sets this Node's alignment constraint inside its Parent. If set, will override the Parent's default alignment.
   * Setting the value to `null` will remove the constraint.
   * Internally it calls `setAlignment(Node, Pos)` static method JavaFX's
   * [[http://docs.oracle.com/javafx/2/api/javafx/scene/layout/BorderPane.html BorderPane]],
   * [[http://docs.oracle.com/javafx/2/api/javafx/scene/layout/StackPane.html StackPane]] and
   * [[http://docs.oracle.com/javafx/2/api/javafx/scene/layout/TilePane.html TilePane]]. Furthermore, it is set
   * `halignment` and `valignment` property (using JavaFX Node's `getProperties()`) and called
   * [[http://docs.oracle.com/javafx/2/api/javafx/scene/layout/GridPane.html#setHalignment(javafx.scene.Node, javafx.geometry.HPos) setHalignment]]
   * and
   * [[http://docs.oracle.com/javafx/2/api/javafx/scene/layout/GridPane.html#setValignment(javafx.scene.Node, javafx.geometry.VPos) setValignment]]
   * static methods from [[http://docs.oracle.com/javafx/2/api/javafx/scene/layout/GridPane.html GridPane]]; this time
   * using `hpos` and `vpos` from Pos argument. Besides, it sets this node `alignment` property towards
   * [[http://docs.oracle.com/javafx/2/api/javafx/scene/Node.html#getProperties() JavaFX Node's getProperties()]] and
   * `setAlignment` static method from
   *
   * '''Do not confuse''' with `alignment` property from [[scalafx.delegate.AlignmentDelegate]]! It refers to alignment
   * ''inside'' element, while `alignmentInParent` refers to element's alignment inside its parent.
   *
   * @param p New node's Position
   */
  def alignmentInParent_=(p: Pos) {
    val delegateProperties = delegate.getProperties
    delegateProperties("alignment") = p.delegate
    delegateProperties("halignment") = p.hpos.delegate
    delegateProperties("valignment") = p.vpos.delegate
    // for compatibility with layouts, which all use different keys
    jfxsl.BorderPane.setAlignment(delegate, p)
    jfxsl.GridPane.setHalignment(delegate, p.hpos)
    jfxsl.GridPane.setValignment(delegate, p.vpos)
    jfxsl.StackPane.setAlignment(delegate, p)
    jfxsl.TilePane.setAlignment(delegate, p)
  }

  /**
   * Pseudo-property that returns this Node's margin constraint inside its Parent if set.
   *
   * @return this Node's margin constraint inside its Parent or `null` if no margin was set.
   */
  def margin: Insets = delegate.getProperties.get("margin").asInstanceOf[jfxg.Insets]

  /**
   * Sets this Node's margin constraint inside its Parent if set. If set, the parent will layout the child with the
   * margin space around it. Setting the value to `null` will remove the constraint.
   * Internally it calls `setMargin(Node, Insets)` static method from JavaFX's `BorderPane`, `FlowPane`,
   * `GridPane`, `HBox`, `StackPane` and `VBox` besides fill this Node's "margin" property.
   *
   * @param i The margin of space around this Node inside its parent.
   */
  def margin_=(i: Insets) {
    delegate.getProperties.put("margin", i.delegate)
    // for compatibility with layouts, which all use different keys
    jfxsl.BorderPane.setMargin(delegate, i)
    jfxsl.FlowPane.setMargin(delegate, i)
    jfxsl.GridPane.setMargin(delegate, i)
    jfxsl.HBox.setMargin(delegate, i)
    jfxsl.StackPane.setMargin(delegate, i)
    jfxsl.TilePane.setMargin(delegate, i)
    jfxsl.VBox.setMargin(delegate, i)
  }

  /**
   * Pseudo-property that returns this Node's hgrow constraint if set.
   *
   * @return the horizontal grow priority for the child or `null` if no priority was set
   */
  def hgrow: Priority = delegate.getProperties.get("hgrow").asInstanceOf[jfxsl.Priority]

  /**
   * Sets the horizontal grow priority for this Node inside its parent. Setting the value to `null` will remove
   * the constraint.
   * Internally it calls `setHgrow(Node, Priority)` static method from JavaFX's `GridPane` and `HBox` besides fill
   * this Node's "hgrow" property.
   *
   * @param p the horizontal grow priority for this Node
   */
  def hgrow_=(p: Priority) {
    delegate.getProperties("hgrow") = p.delegate
    // for compatibility with layouts, which all use different keys
    jfxsl.GridPane.setHgrow(delegate, p)
    jfxsl.HBox.setHgrow(delegate, p)
  }

  /**
   * Pseudo-property that returns this Node's vgrow constraint if set.
   *
   * @return the vertical grow priority for the child or `null` if no priority was set
   */
  def vgrow: Priority = delegate.getProperties.get("vgrow").asInstanceOf[jfxsl.Priority]

  /**
   * Sets the vertical grow priority for this Node inside its parent. Setting the value to `null` will remove
   * the constraint.
   * Internally it calls `setVgrow(Node, Priority)` static method from JavaFX's `GridPane` and `VBox` besides fill
   * this Node's "vgrow" property.
   *
   * @param p the vertical grow priority for this Node
   */
  def vgrow_=(p: Priority) {
    delegate.getProperties("vgrow") = p.delegate
    // for compatibility with layouts, which all use different keys
    jfxsl.GridPane.setVgrow(delegate, p)
    jfxsl.VBox.setVgrow(delegate, p)
  }

  /**
   * If the node is resizable, will set its layout bounds to its current preferred width and height.
   */
  def autosize() {
    delegate.autosize()
  }

  /**
   * Returns true if the given point (specified in the local coordinate space of this Node) is
   * contained within the shape of this Node.
   */
  def contains(localX: Double, localY: Double) = delegate.contains(localX, localY)

  /**
   * Returns true if the given point (specified in the local coordinate space of this Node) is
   * contained within the shape of this Node.
   */
  def contains(localPoint: Point2D) = delegate.contains(localPoint)

  /**
   * Fires the specified event.
   */
  def fireEvent(event: Event) {
    delegate.fireEvent(event)
  }

  /**
   * The 'alphabetic' (or 'roman') baseline offset from the node's layoutBounds.minY location
   * that should be used when this node is being vertically aligned by baseline with other nodes.
   */
  def baselineOffset = delegate.getBaselineOffset

  /**
   * Returns true if the given bounds (specified in the local coordinate space of this Node)
   * intersects the shape of this Node.
   */
  def intersects(localBounds: Bounds) = delegate.intersects(localBounds)

  /**
   * Returns true if the given rectangle (specified in the local coordinate space of this Node)
   * intersects the shape of this Node.
   */
  def intersects(localX: Double, localY: Double, localWidth: Double, localHeight: Double) =
    delegate.intersects(localX, localY, localWidth, localHeight)

  /**
   * Transforms a bounds from the local coordinate space of this Node into the coordinate space of
   * its parent.
   */
  def localToParent(localBounds: Bounds) = delegate.localToParent(localBounds)

  /**
   * Transforms a point from the local coordinate space of this Node into the coordinate space of
   * its parent.
   */
  def localToParent(localX: Double, localY: Double) = delegate.localToParent(localX, localY)

  /**
   * Transforms a point from the local coordinate space of this Node into the coordinate space of
   * its parent.
   */
  def localToParent(localPoint: Point2D) = delegate.localToParent(localPoint)

  /**
   * Transforms a bounds from the local coordinate space of this Node into the coordinate space of
   * its Scene.
   */
  def localToScene(localBounds: Bounds) = delegate.localToScene(localBounds)

  /**
   * Transforms a point from the local coordinate space of this Node into the coordinate space of
   * its Scene.
   */
  def localToScene(localX: Double, localY: Double) = delegate.localToScene(localX, localY)

  /**
   * Transforms a point from the local coordinate space of this Node into the coordinate space of
   * its Scene.
   */
  def localToScene(localPoint: Point2D) = delegate.localToScene(localPoint)

  /**
   * Finds this Node, or the first sub-node, based on the given CSS selector.
   */
  def lookup(selector: String): Node = delegate.lookup(selector)

  /**
   * Finds all Nodes, including this one and any children, which match the given CSS selector.
   */
  def lookupAll(selector: String) = delegate.lookupAll(selector)

  /**
   * Returns the node's maximum height for use in layout calculations.
   */
  def maxHeight(width: Double) = delegate.maxHeight(width)

  /**
   * Returns the node's maximum width for use in layout calculations.
   */
  def maxWidth(height: Double) = delegate.maxWidth(height)

  /**
   * Returns the node's minimum height for use in layout calculations.
   */
  def minHeight(width: Double) = delegate.minHeight(width)

  /**
   * Returns the node's minimum width for use in layout calculations.
   */
  def minWidth(height: Double) = delegate.minWidth(height)

  /**
   * Transforms a rectangle from the coordinate space of the parent into the local coordinate
   * space of this Node.
   */
  def parentToLocal(parentBounds: Bounds) = delegate.parentToLocal(parentBounds)

  /**
   * Transforms a point from the coordinate space of the parent into the local coordinate space
   * of this Node.
   */
  def parentToLocal(parentX: Double, parentY: Double) = delegate.parentToLocal(parentX, parentY)

  /**
   * Transforms a point from the coordinate space of the parent into the local coordinate space
   * of this Node.
   */
  def parentToLocal(parentPoint: Point2D) = delegate.parentToLocal(parentPoint)

  /**
   * Sets the node's layoutX and layoutY translation properties in order to relocate this node
   * to the x,y location in the parent.
   */
  def relocate(x: Double, y: Double) {
    delegate.relocate(x, y)
  }

  /**
   * Requests that this Node get the input focus, and that this Node's top-level ancestor become
   * the focused window.
   */
  def requestFocus() {
    delegate.requestFocus()
  }

  /**
   * If the node is resizable, will set its layout bounds to the specified width and height.
   */
  def resize(width: Double, height: Double) {
    delegate.resize(width, height)
  }

  /**
   * If the node is resizable, will set its layout bounds to the specified width and height.
   */
  def resizeRelocate(x: Double, y: Double, width: Double, height: Double) {
    delegate.resizeRelocate(x, y, width, height)
  }

  /**
   * Transforms a rectangle from the coordinate space of the Scene into the local coordinate space
   * of this Node.
   */
  def sceneToLocal(sceneBounds: Bounds) = delegate.sceneToLocal(sceneBounds)

  /**
   * Transforms a point from the coordinate space of the Scene into the local coordinate space
   * of this Node.
   */
  def sceneToLocal(sceneX: Double, sceneY: Double) = delegate.sceneToLocal(sceneX, sceneY)

  /**
   * Transforms a point from the coordinate space of the Scene into the local coordinate space
   * of this Node.
   */
  def sceneToLocal(scenePoint: Point2D) = delegate.sceneToLocal(scenePoint)

  /**
   * Takes a snapshot of this node and returns the rendered image when it is ready.
   */
  def snapshot(params: SnapshotParameters, image: WritableImage): WritableImage =
    delegate.snapshot(params, image)

  /**
   * Takes a snapshot of this node at the next frame and calls the specified callback method when the image is ready.
   */
  def snapshot(callback: jfxs.SnapshotResult => Unit, params: SnapshotParameters, image: WritableImage) {
    delegate.snapshot(callback, params, image)
  }

  /**
   * Confirms a potential drag and drop gesture that is recognized over this Node.
   */
  def startDragAndDrop(transferModes: jfxsi.TransferMode*) =
    delegate.startDragAndDrop(transferModes: _*)

  /**
   * Starts a full press-drag-release gesture with this node as gesture source.
   */
  def startFullDrag() {
    delegate.startFullDrag()
  }

  /**
   * Moves this Node to the back of its sibling nodes in terms of z-order.
   */
  def toBack() {
    delegate.toBack()
  }

  /**
   * Moves this Node to the front of its sibling nodes in terms of z-order.
   */
  def toFront() {
    delegate.toFront()
  }

  /**
   * An affine transform that holds the computed local-to-parent transform.
   * This is the concatenation of all transforms in this node, including all of the convenience transforms.
   *
   * @since 2.2
   */
  def localToParentTransform: Transform = delegate.localToParentTransform

  /**
   * An affine transform that holds the computed local-to-scene transform.
   * This is the concatenation of all transforms in this node's parents and in this node,
   * including all of the convenience transforms.
   *
   * @since 2.2
   */
  def localToSceneTransform: Transform = delegate.localToSceneTransform

  /**
   * Defines a function to be called when user performs a rotation action.
   *
   * @since 2.2
   */
  def onRotate = delegate.onRotateProperty
  def onRotate_=(v: jfxe.EventHandler[jfxsi.RotateEvent]) {
    onRotate() = v
  }

  /**
   * Defines a function to be called when a rotation gesture ends.
   *
   * @since 2.2
   */
  def onRotationFinished = delegate.onRotationFinishedProperty()
  def onRotationFinished_=(v: jfxe.EventHandler[jfxsi.RotateEvent]) {
    onRotationFinished() = v
  }

  /**
   * Defines a function to be called when a rotation gesture starts.
   *
   * @since 2.2
   */
  def onRotationStarted = delegate.onRotationFinishedProperty()
  def onRotationStarted_=(v: jfxe.EventHandler[jfxsi.RotateEvent]) {
    onRotationStarted() = v
  }

  /**
   * Defines a function to be called when a Scroll gesture ends.
   *
   * @since 2.2
   */
  def onScrollFinished = delegate.onScrollFinishedProperty()
  def onScrollFinished_=(v: jfxe.EventHandler[jfxsi.ScrollEvent]) {
    onScrollFinished() = v
  }

  /**
   * Defines a function to be called when a Scroll gesture starts.
   *
   * @since 2.2
   */
  def onScrollStarted = delegate.onScrollStartedProperty()
  def onScrollStarted_=(v: jfxe.EventHandler[jfxsi.ScrollEvent]) {
    onScrollStarted() = v
  }

  /**
   * Defines a function to be called when a Swipe Down gesture starts.
   *
   * @since 2.2
   */
  def onSwipeDown = delegate.onSwipeDownProperty()
  def onSwipeDown_=(v: jfxe.EventHandler[jfxsi.SwipeEvent]) {
    onSwipeDown() = v
  }

  /**
   * Defines a function to be called when a Swipe Down gesture starts.
   *
   * @since 2.2
   */
  def onSwipeLeft = delegate.onSwipeLeftProperty()
  def onSwipeLeft_=(v: jfxe.EventHandler[jfxsi.SwipeEvent]) {
    onSwipeLeft() = v
  }

  /**
   * Defines a function to be called when a Swipe Up gesture starts.
   *
   * @since 2.2
   */
  def onSwipeUp = delegate.onSwipeUpProperty()
  def onSwipeUp_=(v: jfxe.EventHandler[jfxsi.SwipeEvent]) {
    onSwipeUp() = v
  }

  /**
   * Defines a function to be called when a Swipe Right gesture starts.
   *
   * @since 2.2
   */
  def onSwipeRight = delegate.onSwipeRightProperty()
  def onSwipeRight_=(v: jfxe.EventHandler[jfxsi.SwipeEvent]) {
    onSwipeRight() = v
  }

  /**
   * Defines a function to be called when user performs a Touch action.
   *
   * @since 2.2
   */
  def onZoom = delegate.onZoomProperty()
  def onZoom_=(v: jfxe.EventHandler[jfxsi.ZoomEvent]) {
    onZoom() = v
  }

  /**
   * Defines a function to be called when a Zoom gesture ends.
   *
   * @since 2.2
   */
  def onZoomFinished = delegate.onZoomFinishedProperty()
  def onZoomFinished_=(v: jfxe.EventHandler[jfxsi.ZoomEvent]) {
    onZoomFinished() = v
  }

  /**
   * Defines a function to be called when a Zoom gesture starts.
   *
   * @since 2.2
   */
  def onZoomStarted = delegate.onZoomStartedProperty()
  def onZoomStarted_=(v: jfxe.EventHandler[jfxsi.ZoomEvent]) {
    onZoomStarted() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Moved action.
   *
   * @since 2.2
   */
  def onTouchMoved = delegate.onTouchMovedProperty()
  def onTouchMoved_=(v: jfxe.EventHandler[jfxsi.TouchEvent]) {
    onTouchMoved() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Pressed action.
   *
   * @since 2.2
   */
  def onTouchPressed = delegate.onTouchPressedProperty()
  def onTouchPressed_=(v: jfxe.EventHandler[jfxsi.TouchEvent]) {
    onTouchPressed() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Released action.
   *
   * @since 2.2
   */
  def onTouchReleased = delegate.onTouchReleasedProperty()
  def onTouchReleased_=(v: jfxe.EventHandler[jfxsi.TouchEvent]) {
    onTouchReleased() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Stationary action.
   *
   * @since 2.2
   */
  def onTouchStationary = delegate.onTouchStationaryProperty()
  def onTouchStationary_=(v: jfxe.EventHandler[jfxsi.TouchEvent]) {
    onTouchStationary() = v
  }

  override protected def eventHandlerDelegate = delegate.asInstanceOf[EventHandled]
}
