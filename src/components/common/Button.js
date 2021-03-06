import React from 'react';
import { Text, TouchableOpacity } from 'react-native';

const Button = ({ onPress, children, btnStyle, txtStyle }) => {
    const { buttonStyle, textStyle } = styles;

    return (
        <TouchableOpacity onPress={onPress} style={[buttonStyle, btnStyle]}>
            <Text style={[textStyle, txtStyle]}>
                {children}
            </Text>
        </TouchableOpacity>
    );
};

const styles = {

    textStyle: {
        alignSelf: 'center',
        color: '#007aff',
        fontSize: 16,
        fontWeight: '500',
        padding: 10,
    },
    buttonStyle: {
        flex: 1,
        alignSelf: 'stretch',
        backgroundColor: '#fff',
        borderRadius: 5,
        borderWidth: 1,
        borderColor: '#007aff',
        marginLeft: 5,
        marginRight: 5,
    }
};


export { Button };
