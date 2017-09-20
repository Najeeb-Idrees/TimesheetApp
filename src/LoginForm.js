import React, { Component } from 'react';
import { View, Text } from 'react-native';
import FontAwesomeIcon from 'react-native-vector-icons/FontAwesome';
import { Hideo } from 'react-native-textinput-effects';
import { Button } from './components/common';

export default class LoginForm extends Component {

  state = { username: '', password: '' };

  onLoginPress() {
    const { username, password } = this.state;

    console.log(username);
    console.log(password);
  }

  render() {
    return (

      <View style={styles.containerStyle}>
        <Text> TimeSheet App!! </Text>
        <Text> TimeSheet App!! </Text>
        <Text> TimeSheet App!! </Text>
        <Text> TimeSheet App!! </Text>
        <Text> TimeSheet App!! </Text>
        <Text> TimeSheet App!! </Text>
        <Text> TimeSheet App!! </Text>


        <View
          style={styles.loginLayoutStyle}
        >
          <Hideo
            iconClass={FontAwesomeIcon}
            iconName='envelope'
            iconColor='white'
            placeholder="Username or Email"
            iconBackgroundColor={'#A8A099'}
            inputStyle={{ color: '#464949' }}
            value={this.state.username}
            onChangeText={(text) => { this.setState({ username: text }) }}
          />
          <Hideo
            style={styles.input}
            iconClass={FontAwesomeIcon}
            iconName='user'
            iconColor='white'
            placeholder="Password"
            secureTextEntry
            iconBackgroundColor={'#A8A099'}
            inputStyle={{ color: '#464949' }}
            value={this.state.password}
            onChangeText={(text) => { this.setState({ password: text }) }}
          />

          <Button
            onPress={this.onLoginPress.bind(this)}
            btnStyle={styles.btnStyle}
          >
            Login
        </Button>

        </View>
      </View>
    );
  }
}

const styles = {
  containerStyle: {
    flex: 1,
    backgroundColor: '#24BE9D',
    paddingLeft: 16,
    paddingRight: 16,
  },
  loginLayoutStyle: {
    flexGrow: 1,
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
    position: 'absolute',
    alignSelf: 'center',
    left: 16,
    right: 16,
  },
  input: {
    marginTop: 4,
  },
  btnStyle: {
    flex: 0,
    marginTop: 10,
    marginLeft: 0,
    marginRight: 0,

  }
};
