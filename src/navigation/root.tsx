import React from 'react';
// import {createNativeStackNavigator} from '@react-navigation/native-stack';
import Screen1 from '../screens/Screen1';
import Screen2 from '../screens/Screen2';
import WelcomeScreen from '../screens/WelcomeScreen';
import {createStackNavigator} from '@react-navigation/stack';

const Stack = createStackNavigator();

export default function RootStackNavigator() {
  return (
    <Stack.Navigator initialRouteName="main">
      <Stack.Screen component={WelcomeScreen} name="main" />
      <Stack.Screen component={Screen1} name="module" />
      <Stack.Screen component={Screen2} name="component" />
    </Stack.Navigator>
  );
}
