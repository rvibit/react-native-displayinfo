import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  getRefreshRate(): number;
  getAlternativeRefreshRates(): number[];
  getAll(): string;
  readonly getConstants: () => {
    ONE: string;
    TWO: string;
  };
  isHdr(): boolean;
}

export default TurboModuleRegistry.getEnforcing<Spec>('Displayinfo');
