<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="_header_sidebars.jsp" %>

        <!-- Character Info Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="dice" id="status"></div>
            <div class="bg-secondary text-center rounded p-4">
                <a style="color: #d41414; font-size: 20px;">Name: ${userCharacter.charName}</a>
                <a>  |  </a>
                <a style="color: #0d6efd; font-size: 20px;">Class: Rogue / Scout</a>
                <a>  |  </a>
                <a style="color: #d41414; font-size: 20px;">Level: ${userCharacter.charLevel}</a>
            </div>
        </div>
        <!-- Character Info End -->

        <!-- Abilities block Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">

                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary text-center rounded p-4">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <table class="table table-borderless">
                                <thead>
                                <tr>
                                    <th scope="col">STR</th><th scope="col">DEX</th><th scope="col">CON</th>
                                    <th scope="col">INT</th><th scope="col">WIS</th><th scope="col">CHA</th>
                                    <th scope="col">Initiative</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>${userCharacter.strAbility + strIncrease}</td><td>${userCharacter.dexAbility + dexIncrease}</td>
                                    <td>${userCharacter.conAbility + conIncrease}</td><td>${userCharacter.intAbility + intIncrease}</td>
                                    <td>${userCharacter.wisAbility + wisIncrease}</td><td>${userCharacter.chaAbility + chaIncrease}</td>

                                    <td><button onclick="diceRoller(${dexMod})" type="button" class="btn btn-danger m-2">${dexMod}</button></td>
                                </tr>
                                <tr>
                                    <td><button onclick="diceRoller(${strMod})" type="button" class="btn btn-danger m-2">${strMod}</button></td>
                                    <td><button onclick="diceRoller(${dexMod})" type="button" class="btn btn-danger m-2">${dexMod}</button></td>
                                    <td><button onclick="diceRoller(${conMod})" type="button" class="btn btn-danger m-2">${conMod}</button></td>
                                    <td><button onclick="diceRoller(${intMod})" type="button" class="btn btn-danger m-2">${intMod}</button></td>
                                    <td><button onclick="diceRoller(${wisMod})" type="button" class="btn btn-danger m-2">${wisMod}</button></td>
                                    <td><button onclick="diceRoller(${chaMod})" type="button" class="btn btn-danger m-2">${chaMod}</button></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- Abilities block end -->

                <!-- Basics (HP, walking) Start -->
                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary text-center rounded p-4">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <table class="table table-borderless">
                                <thead>
                                <tr>
                                    <!-- Hit points will be introduced with class update -->
                                    <th scope="col">Proficiency</th><th scope="col">Walking</th><th scope="col">Hit Points</th>
                                    <th scope="col">Modify:</th>
                                    <th scope="col"><button type="button" class="btn btn-danger m-2">plus</button></th>
                                    <th scope="col"><button type="button" class="btn btn-danger m-2">minus</button></th>
                                    <th>Armor Class</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>${userCharacter.proficiency}</td><td>${userCharacter.race.raceWalkingSpeed}ft</td><td>29 / 51</td>
                                    <td><form><input name="health" type="text" class="form-control"></form></td>
                                    <td></td><td></td><td>${armorClass}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Basics end -->

        <!-- Skills and saving throws -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">
                <div class="col-sm-6 col-xl-3">
                    <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                        <div class="ms-3">
                            <table class="table">
                                <thead>
                                <tr><th scope="col">Saving Throws</th><th scope="col">Modifier</th></tr>
                                </thead>
                                <tbody>
                                <!-- In later versions proficiency will be picked for certain saving throws --->
                                <tr><td>Strength</td><td><button onclick="diceRoller(${strMod})"  type="button" class="btn btn-danger m-2">${strMod}</button></td></tr>
                                <tr><td>Dexterity</td><td><button onclick="diceRoller(${dexMod})"  type="button" class="btn btn-danger m-2">${dexMod}</button></td></tr>
                                <tr><td>Constitution</td><td><button onclick="diceRoller(${conMod})"  type="button" class="btn btn-danger m-2">${conMod}</button></td></tr>
                                <tr><td>Intelligence</td><td><button onclick="diceRoller(${intMod})"  type="button" class="btn btn-danger m-2">${intMod}</button></td></tr>
                                <tr><td>Wisdom</td><td><button onclick="diceRoller(${wisMod})"  type="button" class="btn btn-danger m-2">${wisMod}</button></td></tr>
                                <tr><td>Charisma</td><td><button onclick="diceRoller(${chaMod})"  type="button" class="btn btn-danger m-2">${chaMod}</button></td></tr>
                                </tbody>
                            </table>

                            <br/><br/>

                            <!-- In later versions proficiency will be picked for certain passive senses --->
                            <table class="table">
                                <thead>
                                <tr><th scope="col">Passive Senses</th><th scope="col">Roll</th></tr>
                                </thead>
                                <tbody>
                                <tr><td>Perception</td><td>${passivePerception}</td></tr>
                                <tr><td>Investigation</td><td>${passiveInvestigation}</td></tr>
                                <tr><td>Insight</td><td>${passiveInsight}</td></tr>
                                </tbody>
                            </table>

                            <br/><br/>

                            <table class="table">
                                <thead>
                                <tr><th scope="col">Proficiencies</th><th scope="col"></th></tr>
                                </thead>
                                <tbody>
                                <tr><td>Armor:</td><td>Light</td></tr>
                                <tr><td>Weapons:</td><td>Simple, Crossbows, Rapier, longsword, Hand</td></tr>
                                <tr><td>Tools:</td><td>Thieves' Tools, Poisoner kit, Playing Cards Set</td></tr>
                                <tr><td>Languages:</td><td>Common, Goblin, Undercommon</td></tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-xl-3">
                    <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                        <div class="ms-3">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col">Skill</th><th scope="col">Modifier</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr><td>Acrobatics</td><td><button onclick="diceRoller(${dexMod})"  type="button" class="btn btn-danger m-2">${dexMod}</button></td></tr>
                                <tr><td>Animal Handling</td><td><button onclick="diceRoller(${wisMod})"  type="button" class="btn btn-danger m-2">${wisMod}</button></td></tr>
                                <tr><td>Arcana</td><td><button onclick="diceRoller(${intMod})"  type="button" class="btn btn-danger m-2">${intMod}</button></td></tr>
                                <tr><td>Athletics</td><td><button onclick="diceRoller(${strMod})"  type="button" class="btn btn-danger m-2">${strMod}</button></td></tr>
                                <tr><td>Deception</td><td><button onclick="diceRoller(${chaMod})"  type="button" class="btn btn-danger m-2">${chaMod}</button></td></tr>
                                <tr><td>History</td><td><button onclick="diceRoller(${intMod})"  type="button" class="btn btn-danger m-2">${intMod}</button></td></tr>
                                <tr><td>Insight</td><td><button onclick="diceRoller(${wisMod})"  type="button" class="btn btn-danger m-2">${wisMod}</button></td></tr>
                                <tr><td>Intimidation</td><td><button onclick="diceRoller(${chaMod})"  type="button" class="btn btn-danger m-2">${chaMod}</button></td></tr>
                                <tr><td>Investigation</td><td><button onclick="diceRoller(${intMod})"  type="button" class="btn btn-danger m-2">${intMod}</button></td></tr>
                                <tr><td>Medicine</td><td><button onclick="diceRoller(${wisMod})"  type="button" class="btn btn-danger m-2">${wisMod}</button></td></tr>
                                <tr><td>Nature</td><td><button onclick="diceRoller(${intMod})"  type="button" class="btn btn-danger m-2">${intMod}</button></td></tr>
                                <tr><td>Perception</td><td><button onclick="diceRoller(${wisMod})"  type="button" class="btn btn-danger m-2">${wisMod}</button></td></tr>
                                <tr><td>Performance</td><td><button onclick="diceRoller(${chaMod})"  type="button" class="btn btn-danger m-2">${chaMod}</button></td></tr>
                                <tr><td>Persuasion</td><td><button onclick="diceRoller(${chaMod})"  type="button" class="btn btn-danger m-2">${chaMod}</button></td></tr>
                                <tr><td>Religion</td><td><button onclick="diceRoller(${intMod})"  type="button" class="btn btn-danger m-2">${intMod}</button></td></tr>
                                <tr><td>Sleight of Hand</td><td><button onclick="diceRoller(${dexMod})"  type="button" class="btn btn-danger m-2">${dexMod}</button></td></tr>
                                <tr><td>Stealth</td><td><button onclick="diceRoller(${dexMod})"  type="button" class="btn btn-danger m-2">${dexMod}</button></td></tr>
                                <tr><td>Survival</td><td><button onclick="diceRoller(${wisMod})"  type="button" class="btn btn-danger m-2">${wisMod}</button></td></tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Skills and saving throws end-->

<%@include file="_footer.jsp" %>