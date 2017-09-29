import React, { Component } from 'react';
import { Text, TouchableWithoutFeedback, View } from 'react-native';
import { CardSection, Card } from '../common';
import { LightSeaGreen } from '../../colors';

class CreateTSListItem extends Component {

    onRowPress() {
    }

    render() {
        const { project, activity, task, hour } = this.props.singleEntry;
        return (
            <Card
                cardStyle={styles.cardStyle}
            >
                <CardSection>
                    <TouchableWithoutFeedback onPress={this.onRowPress.bind(this)}>
                        <View style={styles.containerStyle}>
                            <View style={styles.square}>
                                <Text style={styles.hourStyle}> {hour} </Text>
                                <Text style={styles.hrsTextStyle}> Hrs </Text>
                            </View>

                            <View style={{ flexDirection: 'column', flex: 0.80, }}>
                                <View style={styles.paStyle}>
                                    <Text style={styles.projectStyle}> {`${project}`} </Text>
                                    <Text style={styles.activityStyle}> {`${activity}`} </Text>
                                </View>

                                <Text style={styles.taskStyle}> {task} </Text>
                            </View>
                        </View>
                    </TouchableWithoutFeedback>
                </CardSection>
            </Card>
        );
    }
}

const styles = {
    containerStyle: {
        flex: 1,
        flexDirection: 'row',
    },
    cardStyle: {
        marginRight: 0,
        marginLeft: 0,
        marginTop: 0,
    },
    square: {
        width: 50,
        flex: 0.20,
        height: 50,
        backgroundColor: LightSeaGreen
    },
    hourStyle: {
        color: '#fff',
        fontWeight: 'bold',
        fontSize: 18,
        textAlign: 'center',
    },
    hrsTextStyle: {
        color: '#fff',
        textAlign: 'center',
    },
    projectStyle: {
        flex: 1,
        alignItems: 'flex-start',        
        fontWeight: 'bold',
        color: '#555D50',
        flexWrap: 'wrap'
    },
    activityStyle: {
        flex: 1,
        alignItems: 'flex-start',
        fontWeight: 'bold',
        color: '#555D50',
        flexWrap: 'wrap'
    },
    taskStyle: {
        paddingLeft: 5,
        alignItems: 'flex-start',
        flexWrap: 'wrap'
    },
    paStyle: {
        flex: 1,
        paddingLeft: 5,
        alignItems: 'flex-start',
        flexDirection: 'row',
    }
};

export default CreateTSListItem;
