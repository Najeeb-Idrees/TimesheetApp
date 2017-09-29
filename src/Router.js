import React from 'react';
import { Scene, Router } from 'react-native-router-flux';
import Login from './components/login/Login';
import MissingTSList from './components/MissingTSList';
import { LightSeaGreen } from './colors';
import CreateTS from './components/logTime/CreateTS';
import test from './components/logTime/test';
import test2 from './components/logTime/test2';

const RouterComponent = () => {
    return (
        <Router>

            {/* <Scene key="auth">
                <Scene
                    key="login"
                    component={Login}
                    title="Login"
                    initial
                    gestureEnabled={false}
                    panHandlers={null}
                    hideNavBar="false"
                />
            </Scene> */}


            <Scene key="main">
                <Scene
                    key="missingTSList"
                    component={MissingTSList}
                    gestureEnabled={false}
                    panHandlers={null}
                    title="Missing Timesheet(s)"
                    navigationBarStyle={{ backgroundColor: LightSeaGreen }}
                    titleStyle={{ color: '#fff', fontWeight: 'bold' }}
                />
                <Scene
                    key="createTS"
                    component={CreateTS}
                    gestureEnabled={false}
                    panHandlers={null}
                    initial
                    title="Log Time"
                    navigationBarStyle={{ backgroundColor: LightSeaGreen }}
                    titleStyle={{ color: '#fff', fontWeight: 'bold' }}
                />
            </Scene>

        </Router >
    );
};

export default RouterComponent;
