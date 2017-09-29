import React, { Component } from 'react';
import { Text, Button, View } from 'react-native';
import { LightSeaGreen } from '../../colors';

class test2 extends Component {

    render() {
        return (

            // <View style={styles.containerStyle}>
            //     <View style={styles.navigationStyle}>
            //         <Text style={styles.textStyle}> Back </Text>
            //         <Text style={styles.textStyle}> Navigation Title </Text>
            //         <Text style={styles.textStyle}> Submit </Text>
            //     </View>
            //     <View style={styles.centerStyle}>
            //         <Button style={styles.btnStyle} title="Button1" />
            //         <Button title="Button2" />
            //         <Button title="Button3" />
            //     </View>
            // </View>
            <View style={{ flex: 1, backgroundColor: "cornflowerblue" }}>
                <View style={{ backgroundColor: "chartreuse" }}><Text>Nothing (17px)</Text></View>
                <View style={{ flex: 0, backgroundColor: "yellow" }}><Text>flex: 0 (17px)</Text></View>

                <View style={{ flex: 0, flexBasis: 15, backgroundColor: "brown" }}><Text>flex: 0, flexBasis: 15 (10px)</Text></View>
                <View style={{ flex: 0, flexGrow: 1, backgroundColor: "orange" }}><Text>flex: 0, flexGrow: 1 (97px)</Text></View>
                <View style={{ flex: 0, flexShrink: 1, backgroundColor: "tan" }}><Text>flex: 0, flexShrink: 1 (17px)</Text></View>
                <View style={{ flex: 0, flexGrow: 1, flexBasis: 10, backgroundColor: "purple" }}><Text>flex: 0, flexGrow: 1, flexBasis: 10 (90px)</Text></View>
                <View style={{ flex: 0, flexShrink: 1, flexBasis: 10, backgroundColor: "gray" }}><Text>flex: 0, flexShrink: 1, flexBasis: 10 (10px with 7px hidden below the next element)</Text></View>

                <View style={{ flex: 1, backgroundColor: "blue" }}><Text>flex: 1 (80px)</Text></View>

                <View style={{ flex: 1, flexBasis: 10, backgroundColor: "cornsilk" }}><Text>flex: 1, flexBasis: 10 (90px)</Text></View>
                <View style={{ flex: 1, flexGrow: 1, backgroundColor: "red" }}><Text>flex: 1, flexGrow: 1 (80px)</Text></View>
                <View style={{ flex: 1, flexShrink: 1, backgroundColor: "green" }}><Text>flex: 1, flexShrink: 1 (80px)</Text></View>
                <View style={{ flex: 1, flexGrow: 1, flexBasis: 10, backgroundColor: "aqua" }}><Text>flex: 1, flexGrow: 1, flexBasis: 10 (90px)</Text></View>
                <View style={{ flex: 1, flexShrink: 1, flexBasis: 10, backgroundColor: "pink" }}><Text>flex: 1, flexShrink: 1, flexBasis: 10 (90px)</Text></View>
            </View>
        );
    }
}

const styles = {
    containerStyle: {
        flex: 1,
    },
    navigationStyle: {
        backgroundColor: LightSeaGreen,
        height: 50,
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'space-between',
    },
    textStyle: {
        padding: 5,
        color: '#fff',
        fontWeight: 'bold',
    },
    centerStyle: {
        alignItems: 'center',
        justifyContent: 'center',
        flex: 1,
    },
    btnStyle: {
        alignSelf: 'flex-end',
    }
};

export default test2;
