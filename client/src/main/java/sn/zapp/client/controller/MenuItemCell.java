/*
 * Copyright 2015 Canoo Engineering AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sn.zapp.client.controller;

import com.canoo.dolphin.client.javafx.FXBinder;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import sn.zappi.common.model.MenuItem;

public class MenuItemCell extends ListCell<MenuItem> {

    public MenuItemCell() {
    }

    @Override
    protected void updateItem(MenuItem item, boolean empty) {
        super.updateItem(item, empty);
        if(item != null) {
            FXBinder.bind(textProperty()).to(item.getTextProperty());
        }
    }
}
