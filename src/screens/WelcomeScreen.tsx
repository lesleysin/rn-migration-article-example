import {useNavigation} from '@react-navigation/native';
import React from 'react';
import {Button, Text, View} from 'react-native';
import NativeMigrationModule from 'MigrationModule/js/NativeMigrationModule';

export default function WelcomeScreen() {
  const navigation = useNavigation();

  return (
    <View>
      <Text>Welcome</Text>
      <Button
        title="navigate to module"
        onPress={() => NativeMigrationModule?.navigate('test')}
      />
      <Button
        title="navigate to component"
        onPress={() => navigation.navigate('component')}
      />
    </View>
  );
}
