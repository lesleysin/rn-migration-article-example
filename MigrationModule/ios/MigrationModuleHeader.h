#ifdef RCT_NEW_ARCH_ENABLED
#import "MigrationModuleSpec/MigrationModuleSpec.h"

@interface MigrationModule : NSObject <NativeMigrationModuleSpec>
#else
#import <React/RCTBridgeModule.h>

@interface MigrationModule : NSObject <RCTBridgeModule>
#endif

@end