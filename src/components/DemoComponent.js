import React, { Component } from 'react';
import { View, Button, NativeModules, } from 'react-native';

export default class DemoComponent extends Component {
    render() {
        return (
            <View>
                <Button
                    onPress={() => NativeModules.ActivityStarter.navigateToExample()}
                    title='Start example activity'
                />
            </View>
        );
    }
}