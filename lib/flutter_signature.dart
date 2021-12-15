import 'dart:async';

import 'package:flutter/services.dart';

class FlutterSignature {
  static const MethodChannel _channel = MethodChannel('flutter_signature');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static dynamic signature(String sha1) async {
    var sign = await _channel.invokeMethod('signature', {"sha1": sha1});
    return sign;
  }
}
