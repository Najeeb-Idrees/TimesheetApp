import React, { Component } from 'react';
import { Text, View, Alert } from 'react-native';

class CreateTS extends Component {

    render() {
        return (

            <View style={styles.container}>
                <Text> Create Timesheet will goes here </Text>
            </View>
        );
    }
}


const styles = {
    container: {
        flex: 1,
        paddingTop: 65,
    },
};


export default CreateTS;
