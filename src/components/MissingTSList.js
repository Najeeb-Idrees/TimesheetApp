import React, { Component } from 'react';
import { ListView } from 'react-native';
import ListItem from './ListItem';

class MissingTSList extends Component {

    constructor() {
        super();
        this.state = {
            names: [
                {
                    id: 0,
                    name: 'Today',
                },
                {
                    id: 1,
                    name: '29-Sep-2017',
                },
                {
                    id: 2,
                    name: '28-Sep-2017',
                },
                {
                    id: 3,
                    name: '27-Sep-2017',
                }
            ]
        };

        const ds = new ListView.DataSource({
            rowHasChanged: (r1, r2) => r1 !== r2
        });

        this.dataSource = ds.cloneWithRows(this.state.names);
    }

    renderRow(data) {
        return <ListItem data={data} />;
    }

    render() {
        return (
            <ListView
                style={styles.container}
                dataSource={this.dataSource}
                renderRow={this.renderRow}
            />
        );
    }
}

const styles = {
    container: {
        flex: 1,
        paddingTop: 65,
        padding: 10,
    },
};

export default MissingTSList;
