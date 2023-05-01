#import <React/RCTLog.h>
#import <React/RCTUIManager.h>
#import <React/RCTViewManager.h>

@interface MigrationComponentManager : RCTViewManager
@end

@implementation MigrationComponentManager

RCT_EXPORT_MODULE(MigrationComponent)

- (UIView *)view
{
  return [[UIView alloc] init];
}

RCT_EXPORT_VIEW_PROPERTY(text, NSString)

@end