import React, { Component } from 'react';
import { Actions } from 'react-native-router-flux';
import { Text, View, TouchableHighlight, NativeModules } from 'react-native';
import { darkGreenColor } from '../colors';

class ListItem extends Component {

    onRowPress(data) {
        // Actions.createTS({ data: this.props.data });
        // Actions.demoComponent();

        NativeModules.ActivityStarter.navigateToExample(data.name);
    }

    render() {
        const { name } = this.props.data;

        return (

            <TouchableHighlight onPress={this.onRowPress.bind(this, this.props.data)}>
                <View>
                    {/* <CardSection> */}
                    <Text style={styles.titleStyle}> {name} </Text>
                    {/* </CardSection> */}
                </View>
            </TouchableHighlight>
        );
    }
}


const styles = {
    titleStyle: {
        fontSize: 18,
        color: '#fff',
        paddingLeft: 15,
        textAlign: 'center',
        borderBottomWidth: 1,
        padding: 10,
        backgroundColor: darkGreenColor,
        flexDirection: 'row',
        borderColor: '#ddd',
    }
};

export default ListItem;
