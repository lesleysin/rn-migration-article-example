#ifdef RCT_NEW_ARCH_ENABLED
#import "MigrationComponent.h"

#import <react/renderer/components/MigrationComponentSpecs/ComponentDescriptors.h>
#import <react/renderer/components/MigrationComponentSpecs/EventEmitters.h>
#import <react/renderer/components/MigrationComponentSpecs/Props.h>
#import <react/renderer/components/MigrationComponentSpecs/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"

using namespace facebook::react;

@interface MigrationComponent () <RCTMigrationComponentViewProtocol>
@end

@implementation MigrationComponent {
  UIView *_view;
  UILabel *_label;
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
  return concreteComponentDescriptorProvider<MigrationComponentComponentDescriptor>();
}

- (instancetype)initWithFrame:(CGRect)frame
{
  if (self = [super initWithFrame:frame]) {
    static const auto defaultProps = std::make_shared<const MigrationComponentProps>();
    _props = defaultProps;

    _view = [[UIView alloc] init];
    _view.backgroundColor = [UIColor redColor];

    _label = [[UILabel alloc] init];
    _label.text = @"Initial value";
    [_view addSubview:_label];

    _label.translatesAutoresizingMaskIntoConstraints = false;
    [NSLayoutConstraint activateConstraints:@[
      [_label.leadingAnchor constraintEqualToAnchor:_view.leadingAnchor],
      [_label.topAnchor constraintEqualToAnchor:_view.topAnchor],
      [_label.trailingAnchor constraintEqualToAnchor:_view.trailingAnchor],
      [_label.bottomAnchor constraintEqualToAnchor:_view.bottomAnchor],
    ]];

    _label.textAlignment = NSTextAlignmentCenter;

    self.contentView = _view;
  }

  return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
  const auto &oldViewProps = *std::static_pointer_cast<MigrationComponentProps const>(_props);
  const auto &newViewProps = *std::static_pointer_cast<MigrationComponentProps const>(props);

  if (oldViewProps.text != newViewProps.text) {
    _label.text = [[NSString alloc] initWithCString:newViewProps.text.c_str() encoding:NSASCIIStringEncoding];
  }

  [super updateProps:props oldProps:oldProps];
}

@end

Class<RCTComponentViewProtocol> MigrationComponentCls(void)
{
  return MigrationComponent.class;
}

#endif