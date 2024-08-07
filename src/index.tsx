import { NativeModules, Platform } from 'react-native';
import type { Spec } from './NativeDisplayinfo';

const LINKING_ERROR =
  `The package 'react-native-displayinfo' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

// @ts-expect-error
const isTurboModuleEnabled = global.__turboModuleProxy != null;

const DisplayinfoModule = isTurboModuleEnabled
  ? require('./NativeDisplayinfo').default
  : NativeModules.Displayinfo;

const Displayinfo: Spec = DisplayinfoModule
  ? DisplayinfoModule
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export const {
  getRefreshRate,
  getAll,
  getAlternativeRefreshRates,
  getConstants,
  isHdr,
} = Displayinfo;
