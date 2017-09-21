import React, { Component } from 'react';
import { View, Text, Image, StyleSheet } from 'react-native';
import LoginForm from './LoginForm';

class Login extends Component {
    render() {
        return (

            <View style={styles.container}>
                <View style={styles.logoContainer} >

                    <Image resizeMode="contain" style={styles.logo} source={require('../../../src/images/ts_logo.png')} />

                    <Text style={styles.AppTextStyle}> Timesheet App </Text>
                    <Text style={styles.CompanyTextStyle}> Technosoft Solutions (Pvt) Ltd. </Text>

                </View>
                <View style={styles.halfHeight} >

                    <LoginForm />
                </View>
            </View >
        );
    }
}

// define your styles
const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#24BE9D',
        flexDirection: 'column'
    },
    halfHeight: {
        flex: 0.50,
    },
    logoContainer: {
        flex: 0.50,
        justifyContent: 'center',
        alignItems: 'center'
    },
    logo: {
        width: 150,
        height: 100
    },
    AppTextStyle: {
        fontSize: 18,
        marginTop: 10,
        color: '#fff',
        fontWeight: 'bold',
    },
    CompanyTextStyle: {
        fontSize: 16,
        marginBottom: 15,
        color: '#fff',
        fontWeight: 'bold',
    },
});

export default Login;
