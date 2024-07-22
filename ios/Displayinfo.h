
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNDisplayinfoSpec.h"

@interface Displayinfo : NSObject <NativeDisplayinfoSpec>
#else
#import <React/RCTBridgeModule.h>

@interface Displayinfo : NSObject <RCTBridgeModule>
#endif

@end
