import React from 'react';
import { Text, StyleSheet, View } from 'react-native';

const Header = (props) => {
    const { viewStyle, header } = styles;

    return (

        <View style={viewStyle}>
            <Text style={header}> {props.headerText} </Text>
        </View>
    );
};

export { Header };


const styles = StyleSheet.create({

    header:
    {
        fontSize: 20,
    },
    viewStyle:
    {
        backgroundColor: '#F8F8F8',
        justifyContent: 'center',
        alignItems: 'center',
        height: 50,
        padding: 15,
        shadowColor: 'black',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.2,
        shadowRadius: 2,
        elevation: 2,
        position: 'relative',
    }
});
