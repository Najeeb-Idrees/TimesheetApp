import React, { Component } from 'react';
import { Text, View, TextInput, Alert, StyleSheet } from 'react-native';
import { Card, CardSection, Button } from '../common';
import Icon from 'react-native-vector-icons/FontAwesome';
import { darkGreenColor } from '../../colors';
import ModalPicker from 'react-native-modal-picker';


class test extends Component {

    state = { textInputValue: '' };

    render() {
        let index = 0;
        const data = [
            { key: index++, section: true, label: 'Projects' },
            { key: index++, label: 'Project1' },
            { key: index++, label: 'Project2' },
            { key: index++, label: 'Project3' },
            { key: index++, label: 'Project4' },
            { key: index++, label: 'Project5' },
            { key: index++, section: true, label: 'Projectss' },
            { key: index++, label: 'Project1' },
            { key: index++, label: 'Project2' },
        ];

        return (


            <View style={modalStyles.selectModalContainer}>
                <ModalPicker
                    data={data}
                    style={modalStyles.selectModalComponent}
                    initValue="Select something yummy!"
                    onChange={(option) => { this.setState({ textInputValue: option.label }) }}
                />

                <TextInput
                    style={modalStyles.inputStyleSelectModal}
                    editable={false}
                    placeholder="Select something yummy!"
                    value={this.state.textInputValue}
                />
            </View>


        );
    }
}


const modalStyles = StyleSheet.create({
    selectModalContainer: {
        position: 'relative',
        width: 200,
        height: 30,
        marginTop: 65,
    },
    selectModalComponent: {
        position: 'absolute',
        opacity: 0,
        width: 200,
        zIndex: 2,
    },
    inputStyleSelectModal: {
        position: 'absolute',
        textAlign: 'right',
        width: 200,
        height: 40,
        zIndex: 1
    }
});

export default test;
