import React, { Component } from 'react';
import { View, Text } from 'react-native';
import FontAwesomeIcon from 'react-native-vector-icons/FontAwesome';
import { Hideo } from 'react-native-textinput-effects';
import { Button, Confirm } from './components/common';

export default class LoginForm extends Component {

  state = { username: '', password: '', showModal: false };

  onLoginPress() {
    const { username, password } = this.state;

    if (username !== '' && password !== '') {
      console.log(username);
      console.log(password);
    }
    else {
      this.setState({ showModal: true });
    }
  }

  onAccept() {
    this.setState({ showModal: false });
  }

  onDecline() {
    this.setState({ showModal: false });
  }
  render() {
    return (

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
          txtStyle={styles.txtStyle}
        >
          Login
        </Button>

        <Confirm
          visible={this.state.showModal}
          onAccept={this.onAccept.bind(this)}
          onDecline={this.onDecline.bind(this)}
          numOfBtns='1'
        >
          Please enter value
                </Confirm>

      </View>
    );
  }
}

const styles = {
  loginLayoutStyle: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#24BE9D',
    paddingLeft: 16,
    paddingRight: 16,
  },
  input: {
    marginTop: 4,
  },
  btnStyle: {
    flex: 0,
    marginTop: 10,
    marginLeft: 0,
    marginRight: 0,
    borderColor: '#17816B',
    backgroundColor: '#17816B',
  },
  txtStyle: {
    color: '#fff',
  }
};
