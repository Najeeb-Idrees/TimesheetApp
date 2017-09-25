import React, { Component } from 'react';
import { Text, View, TextInput, Alert, ListView } from 'react-native';
import { Card, CardSection, Button } from '../common';
import Icon from 'react-native-vector-icons/FontAwesome';
import ModalPicker from 'react-native-modal-picker';

class CreateTS extends Component {

    constructor(props) {
        super(props);

        this.state = {
            project: 'Select Project',
            activity: 'Select Activity',
            hour: '',
            task: '',
            timesheet: []
        };

        const ds = new ListView.DataSource({
            rowHasChanged: (r1, r2) => r1 !== r2
        });

        this.dataSource = ds.cloneWithRows(this.state.timesheet);
    }


    onAddTSPress() {
        const { project, activity, task, hour } = this.state;

        console.log(project);
        console.log(activity);
        console.log(task);
        console.log(hour);

        this.setState({
            timesheet: [...this.state.timesheet, project]
        });
    }

    renderRow(data) {
        console.log(`${data} $""`);
        return <Text> {data} </Text>;
    }

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

        const { containerStyle, labelStyle, valueTextStyle, cardSty, iconStyle, inputContainerStyles } = styles;

        return (

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
                                    data={data}
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
                {/* <CardSection> */}
                <Button
                    onPress={this.onAddTSPress.bind(this)}
                    btnStyle={styles.btnStyle}
                    txtStyle={styles.txtStyle}
                >
                    Add
                </Button>
                {/* </CardSection> */}
                {/* </Card > */}

                <ListView
                    style={styles.listViewContianer}
                    dataSource={this.dataSource}
                    renderRow={this.renderRow}
                    enableEmptySections
                />

            </View >
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
