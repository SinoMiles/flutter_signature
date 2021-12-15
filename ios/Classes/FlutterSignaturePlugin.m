#import "FlutterSignaturePlugin.h"
#if __has_include(<flutter_signature/flutter_signature-Swift.h>)
#import <flutter_signature/flutter_signature-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "flutter_signature-Swift.h"
#endif

@implementation FlutterSignaturePlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterSignaturePlugin registerWithRegistrar:registrar];
}
@end
