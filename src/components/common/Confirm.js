import React, { Component } from 'react';
import { Text, View, Modal } from 'react-native';
import { CardSection } from './CardSection';
import { Button } from './Button';


class Confirm extends Component {


    state = { num: this.props.numOfBtns };

    renderButton() {
        if (this.state.num === '1') {
            return (
                <Button onPress={this.props.onAccept}>Ok</Button>
            );
        } else {
            return (
                <View>
                    <Button onPress={this.props.onAccept}>Yes</Button>
                    <Button onPress={this.props.onDecline}>No</Button>
                </View>
            );
        }
    }

    render() {
        const { containerStyle, textStyle, cardSectionStyle } = styles;

        return (
            <Modal
                visible={this.props.visible}
                transparent
                animationType="slide"
                onRequestClose={() => { }}
            >
                <View style={containerStyle}>
                    <CardSection style={cardSectionStyle}>
                        <Text style={textStyle}>{this.props.children}</Text>
                    </CardSection>

                    <CardSection>
                        {this.renderButton()}
                    </CardSection>
                </View>
            </Modal >
        );
    }
};

const styles = {
    cardSectionStyle: {
        // jutifyContent: 'center',

    },
    textStyle: {
        flex: 1,
        fontSize: 18,
        textAlign: 'center',
        paddingTop: 10,
        paddingBottom: 10,
        // lineHeight: 40,
    },
    containerStyle: {
        backgroundColor: 'rgba(0, 0, 0, 0.75)',
        position: 'relative',
        paddingLeft: 10,
        paddingRight: 10,
        flex: 1,
        justifyContent: 'center',

    }
};

export { Confirm };
