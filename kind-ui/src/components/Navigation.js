// You can import Ionicons from @expo/vector-icons if you use Expo or
// react-native-vector-icons/Ionicons otherwise.
import * as React from 'react';
import { Text, View } from 'react-native';
import { Ionicons } from '@expo/vector-icons';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { NavigationContainer } from '@react-navigation/native';

import Form from '../components/Form'

function HomeScreen() {
  return (
    <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
      <Text>Home!</Text>
    </View>
  );
}


const Tab = createBottomTabNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Tab.Navigator
        screenOptions={({ route }) => ({
          tabBarIcon: ({ focused, color, size }) => {
            let iconName;

            if (route.name === 'Kind List') {
              iconName = focused
                ? 'list-circle-sharp'
                : 'list-circle-sharp';
            } else if (route.name === 'Add to Kind List') {
              iconName = focused ? 'add-circle' : 'add-circle';
            }

            // You can return any component that you like here!
            return <Ionicons name={iconName} size={size} color={color} />;
          },
          tabBarActiveTintColor: 'darkgreen',
          tabBarInactiveTintColor: 'gray',
        })}
      >
        <Tab.Screen name="Kind List" component={HomeScreen} />
        <Tab.Screen name="Add to Kind List" component={Form} />
      </Tab.Navigator>
    </NavigationContainer>
  );
}
