import React, { Component } from 'react';
import { ScrollView, StyleSheet, View } from 'react-native';
import FontAwesomeIcon from 'react-native-vector-icons/FontAwesome';
import MaterialsIcon from 'react-native-vector-icons/MaterialIcons';
import { Hideo, Kohana } from 'react-native-textinput-effects';

export default class LoginForm extends Component {
  render() {
    return (
      <ScrollView
        style={styles.container}
      >
       
        <View style={styles.card}>
          <Hideo
            iconClass={FontAwesomeIcon}
            iconName='envelope'
            iconColor='white'
            iconBackgroundColor={'#859588'}
            inputStyle={{ color: '#464949' }}
            iconSize={30}
            onChangeText={(text) => { this.setState({textValue: text})}}
          />

          <Hideo
            style={styles.input}
            iconClass={FontAwesomeIcon}
            iconName='user'
            iconColor='white'
            secureTextEntry
            iconBackgroundColor={'#A8A099'}
            inputStyle={{ color: '#464949' }}
            onChangeText={(text) => { this.setState({textValue: text}) }}
          />

          <Kohana
    style={{ backgroundColor: '#f9f5ed' }}
    label={'Username or Email'}
    iconClass={MaterialsIcon}
    iconName={'directions-bus'}
    iconColor={'#f4d29a'}
    labelStyle={{ color: '#91627b' }}
    inputStyle={{ color: '#91627b' }}
    useNativeDriver
  />
        </View>
      </ScrollView>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 24,
    backgroundColor: '#24BE9D',
  },
  card: {
    padding: 16,
  },
  input: {
    marginTop: 4,
  },
});
