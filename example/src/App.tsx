import { useState, useEffect } from 'react';
import { StyleSheet, View, Text } from 'react-native';
import {
  getRefreshRate,
  getAlternativeRefreshRates,
  getConstants,
  isHdr,
} from 'react-native-displayinfo';

export default function App() {
  const [result] = useState<number | undefined>();

  useEffect(() => {
    console.log(getRefreshRate());
    console.log(isHdr());
    console.log(getAlternativeRefreshRates());
    console.log(getConstants());
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
