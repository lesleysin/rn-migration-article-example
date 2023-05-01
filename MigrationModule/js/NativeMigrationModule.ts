import type {TurboModule} from 'react-native/Libraries/TurboModule/RCTExport';
import {TurboModuleRegistry} from 'react-native';

export interface Spec extends TurboModule {
  navigate(data?: string): Promise<string>;
}

export default TurboModuleRegistry.get<Spec>('MigrationModule') as Spec | null;
