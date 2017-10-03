import React from 'react';
import { Scene, Router, Actions } from 'react-native-router-flux';
import Login from './components/login/Login';
import MissingTSList from './components/MissingTSList';
import { LightSeaGreen } from './colors';
import CreateTS from './components/logTime/CreateTS';
import Settings from './components/Settings';
import test from './components/logTime/test';
import DemoComponent from './components/DemoComponent';

const RouterComponent = () => {
    return (
        <Router>

            <Scene key="auth">
                <Scene
                    key="login"
                    component={Login}
                    title="Login"
                    initial
                    gestureEnabled={false}
                    panHandlers={null}
                    hideNavBar="false"
                />
            </Scene>


            <Scene key="main">
                <Scene
                    key="missingTSList"
                    component={MissingTSList}
                    gestureEnabled={false}
                    rightButtonImage={require('./images/settings.png')}
                    onRight={() => Actions.settings()}
                    initial
                    panHandlers={null}
                    title="Missing Timesheet(s)"
                    navigationBarStyle={{ backgroundColor: LightSeaGreen }}
                    titleStyle={{ color: '#fff', fontWeight: 'bold' }}
                />
                <Scene
                    key="demoComponent"
                    component={DemoComponent}
                    gestureEnabled={false}
                    backButtonImage={require('./images/arrow_back.png')}
                    panHandlers={null}
                    title="Log Time"
                    hideNavBar
                    navigationBarStyle={{ backgroundColor: LightSeaGreen }}
                    titleStyle={{ color: '#fff', fontWeight: 'bold' }}
                />
                <Scene
                    key="createTS"
                    component={CreateTS}
                    gestureEnabled={false}
                    backButtonImage={require('./images/arrow_back.png')}
                    panHandlers={null}
                    title="Log Time"
                    navigationBarStyle={{ backgroundColor: LightSeaGreen }}
                    titleStyle={{ color: '#fff', fontWeight: 'bold' }}
                />
                <Scene
                    key="settings"
                    component={Settings}
                    gestureEnabled={false}
                    panHandlers={null}
                    backButtonImage={require('./images/arrow_back.png')}
                    title="Settings"
                    navigationBarStyle={{ backgroundColor: LightSeaGreen }}
                    titleStyle={{ color: '#fff', fontWeight: 'bold' }}
                />
            </Scene>

        </Router >
    );
};

export default RouterComponent;
