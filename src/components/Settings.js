import React, { Component } from 'react';
import { Text, View } from 'react-native';
import ModalPicker from 'react-native-modal-picker';
import { Card, CardSection, Button } from './common';
import Icon from 'react-native-vector-icons/FontAwesome';

class Settings extends Component {
    constructor(props) {
        super(props);

        this.state = {
            project: 'Select Project',
            activity: 'Select Activity',
        };

        console.log('Here at constructor!');
    }

    render() {
        const { containerStyle, labelStyle, valueTextStyle, cardSty, iconStyle, inputContainerStyles } = styles;
        let index = 0;
        const data = [
            { key: index++, section: true, label: 'Projects' },
            { key: index++, label: 'FOAS' },
            { key: index++, label: 'CSymplicity' },
            { key: index++, label: 'Cloud Vote' },
            { key: index++, label: 'MCI Assist' },
            { key: index++, label: 'TS HR' },
            { key: index++, label: 'Secure Browser/Messaging' },
            { key: index++, label: 'Test Taker App' },
            { key: index++, label: 'HealthSlate Pro' },
            { key: index++, label: 'Health Touch' },
            { key: index++, label: 'Test' },
        ];


        let index1 = 0;
        const data1 = [
            { key: index1++, section: true, label: 'Activities' },
            { key: index1++, label: 'Coding' },
            { key: index1++, label: 'Testing' },
            { key: index1++, label: 'Outage' },
            { key: index1++, label: 'Design' },
            { key: index1++, label: 'User Interface Creation' },
            { key: index1++, label: 'Scrum' },
            { key: index1++, label: 'Test Cases' },
        ];

        return (
            <Card
                cardStyle={cardSty}
            >
                <CardSection>
                    <View style={containerStyle}>
                        <Text style={labelStyle}> Project </Text>

                        <View style={inputContainerStyles}>
                            <ModalPicker
                                style={{ flex: 1, flexDirection: 'row', }}
                                data={data}
                                onChange={(option) => { this.setState({ project: option.label }) }}>

                                <Text
                                    style={valueTextStyle}
                                >
                                    {this.state.project}
                                </Text>

                            </ModalPicker>
                            <Icon
                                style={iconStyle}
                                name='angle-down' />

                        </View>
                    </View>
                </CardSection>
                <CardSection>
                    <View style={containerStyle}>
                        <Text style={labelStyle}> Activity </Text>
                        <View style={inputContainerStyles}>

                            <ModalPicker
                                style={{ flex: 1, flexDirection: 'row', }}
                                data={data1}
                                onChange={(option) => { this.setState({ activity: option.label }) }}>

                                <Text
                                    style={valueTextStyle}
                                >
                                    {this.state.activity}
                                </Text>

                            </ModalPicker>
                            <Icon
                                style={iconStyle}
                                name='angle-down' />

                        </View>
                    </View>
                </CardSection>
            </Card>
        );
    }
}

const styles = {
    test: {
        flex: 1,
        height: 40
    },
    inputContainerStyles: {
        flex: 3,
        flexDirection: 'row',
        borderRadius: 4,
        borderWidth: 0.5,
        borderColor: '#d6d7da',
    },
    valueTextStyle: {
        color: '#000',
        width: 200,
        textAlign: 'center',
        fontSize: 15,
        marginTop: 7,
        flex: 1,
        paddingLeft: 10,
    },
    iconStyle: {
        alignSelf: 'center',
        paddingRight: 10,
    },
    labelStyle: {
        fontSize: 15,
        paddingLeft: 20,
        alignSelf: 'center',
        flex: 1
    },
    containerStyle: {
        height: 40,
        flex: 1,
        flexDirection: 'row',
    },
    cardSty: {
        marginTop: 65,

    },
    listViewContianer: {
        marginTop: 10,
        padding: 10,
    },
    btnStyle: {
        flex: 0,
        marginTop: 5,
        marginLeft: 5,
        marginRight: 5,
        borderColor: '#17816B',
        backgroundColor: '#17816B',
        alignItems: 'flex-end',
        justifyContent: 'flex-end'
    },
    txtStyle: {
        color: '#fff',
    },
};

export default Settings;
