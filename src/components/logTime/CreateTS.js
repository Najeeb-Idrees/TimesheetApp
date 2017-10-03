import React, { Component } from 'react';
import { Text, View, TextInput, ScrollView, ListView } from 'react-native';
import { Card, CardSection, Button } from '../common';
import Icon from 'react-native-vector-icons/FontAwesome';
import ModalPicker from 'react-native-modal-picker';
import CreateTSListItem from './CreateTSListItem';
import Swipeout from 'react-native-swipeout';

class CreateTS extends Component {

    constructor(props) {
        super(props);

        this.ds = new ListView.DataSource({
            rowHasChanged: (r1, r2) => r1 !== r2
        });

        this.state = {
            // project: 'Select Project',
            // activity: 'Select Activity',
            hour: '',
            task: '',
            timesheet: [],
            dataSource: this.ds.cloneWithRows([])
        };

        console.log('Here at constructor!');
    }

    onAddTSPress() {
        const { project, activity, task, hour } = this.state;

        console.log(project);
        console.log(activity);
        console.log(task);
        console.log(hour);

        this.setState({
            timesheet: [...this.state.timesheet, { time: { project, activity, task, hour } }]
        }, function () {
            console.log(`${this.state.timesheet}`);

            const newDataSource = this.ds.cloneWithRows(this.state.timesheet);
            this.setState({ dataSource: newDataSource });
        });

        console.log('Here button press!');
    }

    deleteNote(rowData) {
        console.log(`delete ${rowData.time.project}`);
    }
    editNote(rowData) {
        console.log(`edit ${rowData.time.activity}`);
    }


    renderRow(data) {
        const swipeBtns = [
            {
                text: 'Edit',
                backgroundColor: 'gray',
                underlayColor: 'rgba(0, 0, 0, 1, 0.6)',
                onPress: () => { this.editNote(data); }
            },
            {
                text: 'Delete',
                backgroundColor: 'red',
                underlayColor: 'rgba(0, 0, 0, 1, 0.6)',
                onPress: () => { this.deleteNote(data); }
            },
        ];

        console.log(`${data}""`);
        return (
            <Swipeout
                right={swipeBtns}
                backgroundColor='transparent'
            >
                <View>
                    <CreateTSListItem
                        singleEntry={data.time}
                    />
                </View>
            </Swipeout>

        );
    }

    render() {
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

        const { containerStyle, labelStyle, valueTextStyle, cardSty, iconStyle, inputContainerStyles } = styles;

        return (

            <ScrollView>
                <View>
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
                        <CardSection>
                            <View style={containerStyle}>
                                <Text style={labelStyle}> Task </Text>
                                <View style={inputContainerStyles}>
                                    <TextInput
                                        style={valueTextStyle}
                                        placeholder="Description of Task"
                                        multiline={false}
                                        onChangeText={(text) => this.setState({ task: text })}
                                        value={this.state.task}
                                    />
                                </View>
                            </View>
                        </CardSection>
                        <CardSection>
                            <View style={containerStyle}>
                                <Text style={labelStyle}> Hours </Text>
                                <View style={inputContainerStyles}>
                                    <TextInput
                                        style={valueTextStyle}
                                        placeholder="0.50 (half hour)"
                                        maxLength={5}
                                        multiline={false}
                                        keyboardType='numeric'
                                        onChangeText={(text) => this.setState({ hour: text })}
                                        value={this.state.hour}
                                    />
                                </View>
                            </View>
                        </CardSection>
                    </Card>
                    <Button
                        onPress={this.onAddTSPress.bind(this)}
                        btnStyle={styles.btnStyle}
                        txtStyle={styles.txtStyle}
                    >
                        Add
                </Button>

                    <ListView
                        scrollEnabled
                        style={styles.listViewContianer}
                        dataSource={this.state.dataSource}
                        renderRow={this.renderRow.bind(this)}
                        enableEmptySections
                    />

                </View >
            </ScrollView>
        );
    }
}


const styles = {
    // container: {
    //     flex: 1,
    //     paddingTop: 65,
    // },
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


export default CreateTS;
