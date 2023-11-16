package com.qs.mvvm.structures.utils.bindingUtils

import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter

object ImageBindingUtils {

    private const val IMAGE_BITMAP = "setImageBitmap"
    private const val IMAGE_URI = "setImageUri"
    private const val IMAGE_IMAGE_URI = "setImageUri"
    private const val SET_IMAGE_RESOURCES = "setImageResources"
    private const val SET_IMAGE_DRAWABLE = "setImageDrawable"
    private const val SET_VECTOR_TINT = "setVectorTint"

    @JvmStatic
    @BindingAdapter(IMAGE_BITMAP)
    fun setImageBitmap(
        imageView: ImageView,
        bitmap: Bitmap?
    ) {
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap)
        } else {
            //imageView.setImageResource(R.drawable.ic_placeholder);
        }
    }

    @JvmStatic
    @BindingAdapter(IMAGE_URI)
    fun setImageUri(
        imageView: ImageView,
        uri: Uri?
    ) {
        if (uri != null) {
            imageView.setImageURI(null)
            imageView.setImageURI(uri)
        }
    }

    @JvmStatic
    @BindingAdapter(IMAGE_IMAGE_URI)
    fun setImageUri(
        imageView: ImageView,
        path: String?
    ) {
        if (path != null) {
            imageView.setImageURI(Uri.parse(path))
        }
    }

    @JvmStatic
    @BindingAdapter(SET_IMAGE_RESOURCES)
    fun setImageResources(
        imageView: ImageView,
        resources: Int?
    ) {
        if (resources != null) {
            imageView.setImageResource(resources)
        }
    }

    @JvmStatic
    @BindingAdapter(SET_IMAGE_DRAWABLE)
    fun setImageDrawable(
        imageView: ImageView,
        drawable: Drawable?
    ) {
        if (drawable != null) {
            imageView.setImageDrawable(drawable)
        }
    }

    @JvmStatic
    @BindingAdapter(SET_VECTOR_TINT)
    fun setVectorTint(
        imageView: ImageView,
        color: Int
    ) {
        ImageViewCompat.setImageTintList(
            imageView,
            ColorStateList.valueOf(ContextCompat.getColor(imageView.context, color))
        )
        //imageView.setColorFilter(ContextCompat.getColor(imageView.getContext(), color), android.graphics.PorterDuff.Mode.SRC_IN);
    }

    @JvmStatic
    @BindingAdapter(SET_VECTOR_TINT)
    fun setVectorTint(
        imageView: ImageView,
        color: String?
    ) {
        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(Color.parseColor(color)))
        //imageView.setColorFilter(ContextCompat.getColor(imageView.getContext(), color), android.graphics.PorterDuff.Mode.SRC_IN);
    }
}