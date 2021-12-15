package com.miles.flutter_signature
import android.content.Context
import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
/** FlutterSignaturePlugin */
class FlutterSignaturePlugin: FlutterPlugin, MethodCallHandler {

  private lateinit var channel : MethodChannel
  private lateinit var context: Context
  private var  sha1="";
  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "flutter_signature")
    channel.setMethodCallHandler(this)
    context=flutterPluginBinding.applicationContext
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    if (call.method == "signature") {
      var sha1=call.argument<String>("sha1")
      val signCheck = SignCheck(context, sha1)
      if (signCheck.check()) {
        //TODO 签名正常
        var s= mapOf<String,Any>(Pair("vaild",true), Pair("sha1",signCheck.cer!!))
        result.success(s)
      } else {
        //TODO 签名不正确
        var s= mapOf<String,Any>(Pair("vaild",false),Pair("sha1",signCheck.cer!!))
        result.success(s)
      }

    } else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }


}
