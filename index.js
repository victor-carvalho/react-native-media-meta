import { NativeModules, Platform } from 'react-native'

const { RNMediaMeta } = NativeModules

export default {
  get(path, options) {
    return RNMediaMeta.get(path, {
      thumb: true,
      ...options,
    })
  },
}
