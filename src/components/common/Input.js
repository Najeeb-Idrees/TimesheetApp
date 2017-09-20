import React from 'react';
import { TextInput, View, Text } from 'react-native';

const Input = ({ labelText, value, onChangeText, placeholder, secureTextEntry, returnKeyType }) => {

    const { inputStyle, labelStyle, containerStyle } = styles;
    return (
        <View style={containerStyle}>
            {/* <Text style={labelStyle}> {labelText} </Text> */}
            <TextInput
                style={inputStyle}
                value={value}
                secureTextEntry={secureTextEntry}
                autoCorrect={false}
                onChangeText={onChangeText}
                placeholder={placeholder}
                returnKeyType={returnKeyType}
                underlineColorAndroid='transparent'
                textAlign='center'
            />
        </View>
    );
};


const styles = {

    inputStyle:
    {
        color: '#000',
        paddingRight: 5,
        paddingLeft: 5,
        fontSize: 18,
        flex: 1,
    },
    // labelStyle:
    // {
    // fontSize: 18,
    // paddingLeft: 20,
    // flex: 1
    // },
    containerStyle:
    {
        height: 40,
        flex: 1,
        flexDirection: 'row',
    }
};

export { Input };
