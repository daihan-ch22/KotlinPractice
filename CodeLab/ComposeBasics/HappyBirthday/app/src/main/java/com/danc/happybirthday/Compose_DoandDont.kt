package com.danc.happybirthday

import androidx.compose.runtime.Composable

class Compose_DoandDont{

    // Do: This function is a descriptive PascalCased noun as a visual UI element
    @Composable
    fun FancyButton(text: String) {}


    // Do: This function is a descriptive PascalCased noun as a non-visual element
    // with presence in the composition
    @Composable
    fun BackButtonHandler() {}


    // Don't: This function is a noun but is not PascalCased!
    @Composable
    fun fancyButton(text: String) {}


    // Don't: This function is PascalCased but is not a noun!
    @Composable
    fun RenderFancyButton(text: String) {}


    // Don't: This function is neither PascalCased nor a noun!
    //@Composable
    //fun drawProfileImage(image: ImageAsset) {}
}