package poke;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

public class PokeGui extends JPanel implements Runnable {
    final static int width = 1366;
    final static int height = 768;
    final static int fontSize = 26;
    private static ArrayList<Monsters> tempTeam = new ArrayList<Monsters>();
    private static ArrayList<Pokemon> myTeam = new ArrayList<Pokemon>();
    public static ArrayList<Pokemon> enemyTeam = new ArrayList<Pokemon>();

    private static boolean attack = false, switchPoke = false, item = false, attack2 = false;

    BattleMech bm = new BattleMech();

    JTextArea battleNarrationArea, myTeamInfo, enemyTeamInfo;
    // ImageIcon myTeamPokemon;
    JLabel myTeamPokelbl, enemyTeamPokelbl;

    Pokemon enemy1 = new Pokemon(Monsters.HAWLUCHA);
    Pokemon enemy2 = new Pokemon(Monsters.TYRANTRUM);
    Pokemon enemy3 = new Pokemon(Monsters.AURORUS);
    Pokemon enemy4 = new Pokemon(Monsters.GOURGEIST);
    Pokemon enemy5 = new Pokemon(Monsters.GOODRA);
    Pokemon enemy6 = new Pokemon(Monsters.GARDEVOIR);

    public void run() {
        startMainMenu();
    }

    public PokeGui() {
    }

    public void startMainMenu() {
        JFrame menuFrame = new JFrame("Pokemon");
        menuFrame.setBounds(1266, 868, width, height);
        menuFrame.setLocationRelativeTo(null);

        menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menuFrame.getContentPane().setLayout(null);

        // start game button
        JButton startBtn = new JButton("Start Game");
        startBtn.setBounds(500, 500, width / 4, height / 15);
        startBtn.setFont(new Font("inhalt", Font.PLAIN, fontSize + 5));

        // end game button
        JButton endBtn = new JButton("Quit Game");
        endBtn.setBounds(500, 600, width / 4, height / 15);
        endBtn.setFont(new Font("inhalt", Font.PLAIN, fontSize + 5));

        // TODO
        ImageIcon pokemonSymbol = new ImageIcon(getClass().getResource("/poke/images/Pokemon.png"));
        JLabel welcomelbl = new JLabel(pokemonSymbol);
        welcomelbl.setBounds(50, 0, 1200, 442);

        ImageIcon pokemonbg = new ImageIcon(getClass().getResource("/poke/images/BG.png"));
        JLabel bg = new JLabel(pokemonbg);
        bg.setBounds(0, 0, 1500, 868);

        menuFrame.getContentPane().add(startBtn);
        menuFrame.getContentPane().add(endBtn);
        menuFrame.getContentPane().add(welcomelbl);
        menuFrame.getContentPane().add(bg);

        menuFrame.setVisible(true);

        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent click) {
                menuFrame.dispose();
                initPokeSelect();
            }
        });

        endBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent click) {
                System.exit(0);
            }
        });
    }

    public void initPokeSelect() {
        JFrame dexFrame = new JFrame("Pokemon");
        dexFrame.setBounds(1266, 868, width, height);
        dexFrame.setLocationRelativeTo(null);
        dexFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dexFrame.getContentPane().setLayout(null);

        // main menu button
        JButton backButton = new JButton("Main Menu");
        backButton.setBounds(900, 43, 250, 70);
        backButton.setFont(new Font("inhalt", Font.PLAIN, fontSize + 2));
        dexFrame.getContentPane().add(backButton);
        backButton.setVisible(true);

        // start fight button
        JButton startFight = new JButton("Start Battle");
        startFight.setBounds(900, 115, 250, 70);
        startFight.setFont(new Font("inhalt", Font.PLAIN, fontSize + 2));
        dexFrame.getContentPane().add(startFight);
        startFight.setVisible(true);

        // remove pokemon button
        JButton removePoke = new JButton("Remove Pokemon");
        removePoke.setBounds(900, 187, 250, 70);
        removePoke.setFont(new Font("inhalt", Font.PLAIN, fontSize - 3));
        dexFrame.getContentPane().add(removePoke);
        removePoke.setVisible(true);

        // displays pokemon info
        JTextArea info = new JTextArea("");
        info.setBounds(63, 43, 600, 230);
        info.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        dexFrame.getContentPane().add(info);
        info.setEditable(false);

        JRadioButton rDelphox = new JRadioButton(Monsters.DELPHOX.getName());
        rDelphox.setBounds(50, 300, 180, 50);
        rDelphox.setFont(new Font("inhalt", Font.PLAIN, fontSize + 3));

        JRadioButton rGardevoir = new JRadioButton(Monsters.GARDEVOIR.getName());
        rGardevoir.setBounds(230, 300, 180, 50);
        rGardevoir.setFont(new Font("inhalt", Font.PLAIN, fontSize + 3));

        JRadioButton rLucario = new JRadioButton(Monsters.LUCARIO.getName());
        rLucario.setBounds(410, 300, 180, 50);
        rLucario.setFont(new Font("inhalt", Font.PLAIN, fontSize + 3));

        JRadioButton rZapdos = new JRadioButton(Monsters.ZAPDOS.getName());
        rZapdos.setBounds(590, 300, 180, 50);
        rZapdos.setFont(new Font("inhalt", Font.PLAIN, fontSize + 3));

        JRadioButton rBlastoise = new JRadioButton(Monsters.BLASTOISE.getName());
        rBlastoise.setBounds(770, 300, 180, 50);
        rBlastoise.setFont(new Font("inhalt", Font.PLAIN, fontSize + 3));

        JRadioButton rAbsol = new JRadioButton(Monsters.ABSOL.getName());
        rAbsol.setBounds(950, 300, 180, 50);
        rAbsol.setFont(new Font("inhalt", Font.PLAIN, fontSize + 3));

        JRadioButton rBlaziken = new JRadioButton(Monsters.BLAZIKEN.getName());
        rBlaziken.setBounds(50, 375, 180, 50);
        rBlaziken.setFont(new Font("inhalt", Font.PLAIN, fontSize + 3));

        JRadioButton rSerperior = new JRadioButton(Monsters.SERPERIOR.getName());
        rSerperior.setBounds(230, 375, 180, 50);
        rSerperior.setFont(new Font("inhalt", Font.PLAIN, fontSize + 3));

        JRadioButton rMagnezone = new JRadioButton(Monsters.MAGNEZONE.getName());
        rMagnezone.setBounds(410, 375, 180, 50);
        rMagnezone.setFont(new Font("inhalt", Font.PLAIN, fontSize + 3));

        JRadioButton rGreninja = new JRadioButton(Monsters.GRENINJA.getName());
        rGreninja.setBounds(590, 375, 180, 50);
        rGreninja.setFont(new Font("inhalt", Font.PLAIN, fontSize + 3));

        JRadioButton rXerneas = new JRadioButton(Monsters.XERNEAS.getName());
        rXerneas.setBounds(770, 375, 180, 50);
        rXerneas.setFont(new Font("inhalt", Font.PLAIN, fontSize + 3));

        JRadioButton rPrimarina = new JRadioButton(Monsters.PRIMARINA.getName());
        rPrimarina.setBounds(950, 375, 180, 50);
        rPrimarina.setFont(new Font("inhalt", Font.PLAIN, fontSize + 3));

        JRadioButton rNinetales = new JRadioButton(Monsters.ALOLANNINETALES.getName());
        rNinetales.setBounds(50, 450, 180, 50);
        rNinetales.setFont(new Font("inhalt", Font.PLAIN, fontSize + 3));

        JRadioButton rCharizard = new JRadioButton(Monsters.CHARIZARD.getName());
        rCharizard.setBounds(230, 450, 180, 50);
        rCharizard.setFont(new Font("inhalt", Font.PLAIN, fontSize + 3));

        JRadioButton rZamazenta = new JRadioButton(Monsters.ZAMAZENTA.getName());
        rZamazenta.setBounds(410, 450, 180, 50);
        rZamazenta.setFont(new Font("inhalt", Font.PLAIN, fontSize + 3));
        dexFrame.setVisible(true);

        // used to add all the pokemon buttons
        JRadioButton[] buttons = { rDelphox, rGardevoir, rLucario, rZapdos, rBlastoise, rAbsol,
                rBlaziken, rSerperior, rMagnezone, rGreninja, rXerneas, rPrimarina,
                rNinetales, rCharizard, rZamazenta };

        ButtonGroup group = new ButtonGroup();

        for (int i = 0; i < buttons.length; i++) {
            dexFrame.getContentPane().add(buttons[i]);
            group.add(buttons[i]);
        }

        // show pokemon picture
        JLabel pokePic = new JLabel(new ImageIcon(getClass().getResource("/poke/images/Gardevoir.png")));
        pokePic.setBounds(670, 43, 250, 250);
        dexFrame.getContentPane().add(pokePic);
        pokePic.setVisible(false);

        // display pokemons within team
        JTextArea teamList = new JTextArea("");
        teamList.setBounds(1130, 300, 200, 200);
        teamList.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        dexFrame.getContentPane().add(teamList);
        teamList.setVisible(true);
        teamList.setEditable(false);

        // this is useless
        JTextArea teamSizeWarning = new JTextArea("Your team can only have 6 pokemon!");
        teamSizeWarning.setBounds(1130, 270, 200, 30);
        teamSizeWarning.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        teamSizeWarning.setForeground(Color.RED);
        dexFrame.getContentPane().add(teamSizeWarning);
        teamSizeWarning.setVisible(false);
        teamSizeWarning.setEditable(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                dexFrame.dispose();
                startMainMenu();
            }
        });

        startFight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (tempTeam.size() < 6) {
                    JOptionPane.showMessageDialog(dexFrame, "You need to have at least 6 Pokemon!",
                            "Not enough Pokemon", JOptionPane.WARNING_MESSAGE);
                } else {
                    dexFrame.dispose();
                    startGuiFight();
                }
            }
        });

        removePoke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (tempTeam.size() > 0) {
                    tempTeam.remove(0);

                    teamList.setText("");
                    for (Monsters poke : tempTeam) {
                        teamList.append(poke.getName() + "\n");
                    }

                    teamList.updateUI();
                } else {
                    JOptionPane.showMessageDialog(dexFrame, "You can't remove anything!", "Empty Team",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // TMR JUST COPY DELPHOX BUTTON FOR OTHER POKEMON
        rDelphox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                info.setBackground(Color.white);
                info.setText(Monsters.DELPHOX.getName() + "\nHP: " + Monsters.DELPHOX.getHP() + "\nATK: "
                        + Monsters.DELPHOX.getATK() + "\nDEF: " + Monsters.DELPHOX.getDEF() + "\nSPD: "
                        + Monsters.DELPHOX.getSPD());

                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Delphox.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if (!tempTeam.contains(Monsters.DELPHOX) && tempTeam.size() < 6) {
                    tempTeam.add(Monsters.DELPHOX);
                    teamList.append("Delphox \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.DELPHOX) && tempTeam.size() == 6) {
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rBlaziken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                info.setBackground(Color.white);
                info.setText(Monsters.BLAZIKEN.getName() + "\nHP: " + Monsters.BLAZIKEN.getHP() + "\nATK: "
                        + Monsters.BLAZIKEN.getATK() + "\nDEF: " + Monsters.BLAZIKEN.getDEF() + "\nSPD: "
                        + Monsters.BLAZIKEN.getSPD());

                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Blaziken.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if (!tempTeam.contains(Monsters.BLAZIKEN) && tempTeam.size() < 6) {
                    tempTeam.add(Monsters.BLAZIKEN);
                    teamList.append("Blaziken \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.BLAZIKEN) && tempTeam.size() == 6) {
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rGardevoir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                info.setBackground(Color.white);
                info.setText(Monsters.GARDEVOIR.getName() + "\nHP: " + Monsters.GARDEVOIR.getHP() + "\nATK: "
                        + Monsters.GARDEVOIR.getATK() + "\nDEF: " + Monsters.GARDEVOIR.getDEF() + "\nSPD: "
                        + Monsters.GARDEVOIR.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Gardevoir.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if (!tempTeam.contains(Monsters.GARDEVOIR) && tempTeam.size() < 6) {
                    tempTeam.add(Monsters.GARDEVOIR);
                    teamList.append("Gardevoir \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.GARDEVOIR) && tempTeam.size() == 6) {
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rLucario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                info.setBackground(Color.white);
                info.setText(Monsters.LUCARIO.getName() + "\nHP: " + Monsters.LUCARIO.getHP() + "\nATK: "
                        + Monsters.LUCARIO.getATK() + "\nDEF: " + Monsters.LUCARIO.getDEF() + "\nSPD: "
                        + Monsters.LUCARIO.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Lucario.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if (!tempTeam.contains(Monsters.LUCARIO) && tempTeam.size() < 6) {
                    tempTeam.add(Monsters.LUCARIO);
                    teamList.append("Lucario \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.LUCARIO) && tempTeam.size() == 6) {
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rZapdos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                info.setBackground(Color.white);
                info.setText(Monsters.ZAPDOS.getName() + "\nHP: " + Monsters.ZAPDOS.getHP() + "\nATK: "
                        + Monsters.ZAPDOS.getATK() + "\nDEF: " + Monsters.ZAPDOS.getDEF() + "\nSPD: "
                        + Monsters.ZAPDOS.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Zapdos.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if (!tempTeam.contains(Monsters.ZAPDOS) && tempTeam.size() < 6) {
                    tempTeam.add(Monsters.ZAPDOS);
                    teamList.append("Zapdos \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.ZAPDOS) && tempTeam.size() == 6) {
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rBlastoise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                info.setBackground(Color.white);
                info.setText(Monsters.BLASTOISE.getName() + "\nHP: " + Monsters.BLASTOISE.getHP() + "\nATK: "
                        + Monsters.BLASTOISE.getATK() + "\nDEF: " + Monsters.BLASTOISE.getDEF() + "\nSPD: "
                        + Monsters.BLASTOISE.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Blastoise.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if (!tempTeam.contains(Monsters.BLASTOISE) && tempTeam.size() < 6) {
                    tempTeam.add(Monsters.BLASTOISE);
                    teamList.append("Blastoise \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.BLASTOISE) && tempTeam.size() == 6) {
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rAbsol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                info.setBackground(Color.white);
                info.setText(Monsters.ABSOL.getName() + "\nHP: " + Monsters.ABSOL.getHP() + "\nATK: "
                        + Monsters.ABSOL.getATK() + "\nDEF: " + Monsters.ABSOL.getDEF() + "\nSPD: "
                        + Monsters.ABSOL.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Absol.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if (!tempTeam.contains(Monsters.ABSOL) && tempTeam.size() < 6) {
                    tempTeam.add(Monsters.ABSOL);
                    teamList.append("Absol \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.ABSOL) && tempTeam.size() == 6) {
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rSerperior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                info.setBackground(Color.white);
                info.setText(Monsters.SERPERIOR.getName() + "\nHP: " + Monsters.SERPERIOR.getHP() + "\nATK: "
                        + Monsters.SERPERIOR.getATK() + "\nDEF: " + Monsters.SERPERIOR.getDEF() + "\nSPD: "
                        + Monsters.SERPERIOR.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Serperior.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if (!tempTeam.contains(Monsters.SERPERIOR) && tempTeam.size() < 6) {
                    tempTeam.add(Monsters.SERPERIOR);
                    teamList.append("Serperior \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.SERPERIOR) && tempTeam.size() == 6) {
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rMagnezone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                info.setBackground(Color.white);
                info.setText(Monsters.MAGNEZONE.getName() + "\nHP: " + Monsters.MAGNEZONE.getHP() + "\nATK: "
                        + Monsters.MAGNEZONE.getATK() + "\nDEF: " + Monsters.MAGNEZONE.getDEF() + "\nSPD: "
                        + Monsters.MAGNEZONE.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Magnezone.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if (!tempTeam.contains(Monsters.MAGNEZONE) && tempTeam.size() < 6) {
                    tempTeam.add(Monsters.MAGNEZONE);
                    teamList.append("Magnezone \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.MAGNEZONE) && tempTeam.size() == 6) {
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rGreninja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                info.setBackground(Color.white);
                info.setText(Monsters.GRENINJA.getName() + "\nHP: " + Monsters.GRENINJA.getHP() + "\nATK: "
                        + Monsters.GRENINJA.getATK() + "\nDEF: " + Monsters.GRENINJA.getDEF() + "\nSPD: "
                        + Monsters.GRENINJA.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Greninja.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if (!tempTeam.contains(Monsters.GRENINJA) && tempTeam.size() < 6) {
                    tempTeam.add(Monsters.GRENINJA);
                    teamList.append("Greninja \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.GRENINJA) && tempTeam.size() == 6) {
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rXerneas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                info.setBackground(Color.white);
                info.setText(Monsters.XERNEAS.getName() + "\nHP: " + Monsters.XERNEAS.getHP() + "\nATK: "
                        + Monsters.XERNEAS.getATK() + "\nDEF: " + Monsters.XERNEAS.getDEF() + "\nSPD: "
                        + Monsters.XERNEAS.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Xerneas.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if (!tempTeam.contains(Monsters.XERNEAS) && tempTeam.size() < 6) {
                    tempTeam.add(Monsters.XERNEAS);
                    teamList.append("Xerneas \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.XERNEAS) && tempTeam.size() == 6) {
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rPrimarina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                info.setBackground(Color.white);
                info.setText(Monsters.PRIMARINA.getName() + "\nHP: " + Monsters.PRIMARINA.getHP() + "\nATK: "
                        + Monsters.PRIMARINA.getATK() + "\nDEF: " + Monsters.PRIMARINA.getDEF() + "\nSPD: "
                        + Monsters.PRIMARINA.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Primarina.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if (!tempTeam.contains(Monsters.PRIMARINA) && tempTeam.size() < 6) {
                    tempTeam.add(Monsters.PRIMARINA);
                    teamList.append("Primarina \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.PRIMARINA) && tempTeam.size() == 6) {
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rNinetales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                info.setBackground(Color.white);
                info.setText(Monsters.ALOLANNINETALES.getName() + "\nHP: " + Monsters.ALOLANNINETALES.getHP()
                        + "\nATK: " + Monsters.ALOLANNINETALES.getATK() + "\nDEF: " + Monsters.ALOLANNINETALES.getDEF()
                        + "\nSPD: " + Monsters.ALOLANNINETALES.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Ninetales.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if (!tempTeam.contains(Monsters.ALOLANNINETALES) && tempTeam.size() < 6) {
                    tempTeam.add(Monsters.ALOLANNINETALES);
                    teamList.append("Alolan Ninetales \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.ALOLANNINETALES) && tempTeam.size() == 6) {
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rCharizard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                info.setBackground(Color.white);
                info.setText(Monsters.CHARIZARD.getName() + "\nHP: " + Monsters.CHARIZARD.getHP() + "\nATK: "
                        + Monsters.CHARIZARD.getATK() + "\nDEF: " + Monsters.CHARIZARD.getDEF() + "\nSPD: "
                        + Monsters.CHARIZARD.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Charizard.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if (!tempTeam.contains(Monsters.CHARIZARD) && tempTeam.size() < 6) {
                    tempTeam.add(Monsters.CHARIZARD);
                    teamList.append("Charizard \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.CHARIZARD) && tempTeam.size() == 6) {
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rZamazenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                info.setBackground(Color.white);
                info.setText(Monsters.ZAMAZENTA.getName() + "\nHP: " + Monsters.ZAMAZENTA.getHP() + "\nATK: "
                        + Monsters.ZAMAZENTA.getATK() + "\nDEF: " + Monsters.ZAMAZENTA.getDEF() + "\nSPD: "
                        + Monsters.ZAMAZENTA.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Zamazenta.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if (!tempTeam.contains(Monsters.ZAMAZENTA) && tempTeam.size() < 6) {
                    tempTeam.add(Monsters.ZAMAZENTA);
                    teamList.append("Zamazenta \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.ZAMAZENTA) && tempTeam.size() == 6) {
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }

    private void startGuiFight() {
        Pokemon poke1 = new Pokemon(tempTeam.get(0));
        Pokemon poke2 = new Pokemon(tempTeam.get(1));
        Pokemon poke3 = new Pokemon(tempTeam.get(2));
        Pokemon poke4 = new Pokemon(tempTeam.get(3));
        Pokemon poke5 = new Pokemon(tempTeam.get(4));
        Pokemon poke6 = new Pokemon(tempTeam.get(5));

        myTeam.add(poke1);
        myTeam.add(poke2);
        myTeam.add(poke3);
        myTeam.add(poke4);
        myTeam.add(poke5);
        myTeam.add(poke6);

        enemyTeam.add(enemy1);
        enemyTeam.add(enemy2);
        enemyTeam.add(enemy3);
        enemyTeam.add(enemy4);
        enemyTeam.add(enemy5);
        enemyTeam.add(enemy6);

        JFrame fightFrame = new JFrame("Battle against Enemy Trainer");
        fightFrame.setBounds(1266, 868, width, height);
        fightFrame.setLocationRelativeTo(null);
        fightFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fightFrame.getContentPane().setLayout(null);
        fightFrame.setFont(new Font("inhalt", Font.PLAIN, fontSize));

        ImageIcon myTeamPokemon = new ImageIcon(
                getClass().getResource("/poke/images/" + myTeam.get(0).getPokePictureName()));
        ImageIcon enemyTeamPokemon = new ImageIcon(
                getClass().getResource("/poke/images/" + enemyTeam.get(0).getPokePictureName()));

        myTeamInfo = new JTextArea(
                myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/" + myTeam.get(0).getTotalHP());
        myTeamInfo.setBounds(100, 60, 400, 70);
        myTeamInfo.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(myTeamInfo);
        myTeamInfo.setVisible(true);
        myTeamInfo.setEditable(false);

        enemyTeamInfo = new JTextArea(enemyTeam.get(0).getName() + "\nHP: " + enemyTeam.get(0).getBattleHP() + "/"
                + enemyTeam.get(0).getTotalHP());
        enemyTeamInfo.setBounds(800, 60, 400, 70);
        enemyTeamInfo.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(enemyTeamInfo);
        enemyTeamInfo.setVisible(true);
        enemyTeamInfo.setEditable(false);

        battleNarrationArea = new JTextArea("What will " + myTeam.get(0).getName() + " do?");

        battleNarrationArea.setLineWrap(true);
        battleNarrationArea.setEditable(false);
        // battleNarrationArea.setVisible(true);

        JScrollPane battleNarration = new JScrollPane(battleNarrationArea);
        battleNarration.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        battleNarration.setBounds(0, 500, 683, 150);
        battleNarration.setFont(new Font("inhalt", Font.PLAIN, fontSize));

        fightFrame.add(battleNarration);
        battleNarration.setVisible(true);
        // fightFrame.setVisible(true);

        JButton fightButton = new JButton("Fight");
        fightButton.setBounds(684, 500, 340, 100);
        fightButton.setHorizontalAlignment(SwingConstants.CENTER);
        fightButton.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(fightButton);
        fightButton.setVisible(true);

        JButton bagButton = new JButton("Bag");
        bagButton.setBounds(1024, 500, 340, 100);
        bagButton.setHorizontalAlignment(SwingConstants.CENTER);
        bagButton.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(bagButton);
        bagButton.setVisible(true);

        JButton switchButton = new JButton("Switch");
        switchButton.setBounds(684, 600, 340, 100);
        switchButton.setHorizontalAlignment(SwingConstants.CENTER);
        switchButton.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(switchButton);
        switchButton.setVisible(true);

        JButton ffButton = new JButton("ff15 go next");
        ffButton.setBounds(1024, 600, 340, 100);
        ffButton.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        ffButton.setHorizontalAlignment(SwingConstants.CENTER);
        fightFrame.getContentPane().add(ffButton);
        ffButton.setVisible(true);

        JButton cancelButton = new JButton("Back");
        cancelButton.setBounds(50, 650, 100, 50);
        cancelButton.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        cancelButton.setHorizontalAlignment(SwingConstants.CENTER);
        fightFrame.getContentPane().add(cancelButton);
        cancelButton.setVisible(false);

        JButton continueButton = new JButton("Continue");
        continueButton.setBounds(434, 650, 200, 50);
        continueButton.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        continueButton.setHorizontalAlignment(SwingConstants.CENTER);
        fightFrame.getContentPane().add(continueButton);
        continueButton.setVisible(false);

        JButton atk1Button = new JButton();
        atk1Button.setBounds(684, 500, 340, 100);
        atk1Button.setHorizontalAlignment(SwingConstants.CENTER);
        atk1Button.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(atk1Button);
        atk1Button.setVisible(false);

        JButton atk2Button = new JButton();
        atk2Button.setBounds(1024, 500, 340, 100);
        atk2Button.setHorizontalAlignment(SwingConstants.CENTER);
        atk2Button.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(atk2Button);
        atk2Button.setVisible(false);

        JButton atk3Button = new JButton();
        atk3Button.setBounds(684, 600, 340, 100);
        atk3Button.setHorizontalAlignment(SwingConstants.CENTER);
        atk3Button.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(atk3Button);
        atk3Button.setVisible(false);

        JButton atk4Button = new JButton();
        atk4Button.setBounds(1024, 600, 340, 100);
        atk4Button.setHorizontalAlignment(SwingConstants.CENTER);
        atk4Button.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(atk4Button);
        atk4Button.setVisible(false);

        // status effect symbols
        ImageIcon paralyze = new ImageIcon(getClass().getResource("/poke/images/paralyze.png"));
        JLabel paralyzelbl = new JLabel(paralyze);
        paralyzelbl.setBounds(0, 100, 50, 50);
        paralyze.setImage(paralyze.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        paralyzelbl.setVisible(false);
        fightFrame.getContentPane().add(paralyzelbl);
        JLabel paralyzelblEnemy = new JLabel(paralyze);
        paralyzelblEnemy.setBounds(1300, 100, 100, 100);
        paralyzelblEnemy.setVisible(false);
        fightFrame.getContentPane().add(paralyzelblEnemy);

        ImageIcon burn = new ImageIcon(getClass().getResource("/poke/images/burn.png"));
        JLabel burnlbl = new JLabel(burn);
        burnlbl.setBounds(0, 150, 100, 100);
        burn.setImage(burn.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        burnlbl.setVisible(false);
        fightFrame.getContentPane().add(burnlbl);
        JLabel burnlblEnemy = new JLabel(burn);
        burnlblEnemy.setBounds(1300, 150, 100, 100);
        burnlblEnemy.setVisible(false);
        fightFrame.getContentPane().add(burnlblEnemy);

        ImageIcon poison = new ImageIcon(getClass().getResource("/poke/images/poison.png"));
        JLabel poisonlbl = new JLabel(poison);
        poisonlbl.setBounds(0, 200, 50, 50);
        poison.setImage(poison.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        poisonlbl.setVisible(false);
        fightFrame.getContentPane().add(poisonlbl);
        JLabel poisonlblEnemy = new JLabel(poison);
        poisonlblEnemy.setBounds(1300, 200, 100, 100);
        poisonlblEnemy.setVisible(false);
        fightFrame.getContentPane().add(poisonlblEnemy);

        ImageIcon freeze = new ImageIcon(getClass().getResource("/poke/images/freeze.png"));
        JLabel freezelbl = new JLabel(freeze);
        freezelbl.setBounds(0, 250, 50, 50);
        freeze.setImage(freeze.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        freezelbl.setVisible(false);
        fightFrame.getContentPane().add(freezelbl);
        JLabel freezelblEnemy = new JLabel(freeze);
        freezelblEnemy.setBounds(1300, 250, 100, 100);
        freezelblEnemy.setVisible(false);
        fightFrame.getContentPane().add(freezelblEnemy);

        ImageIcon sleep = new ImageIcon(getClass().getResource("/poke/images/sleep.png"));
        JLabel sleeplbl = new JLabel(sleep);
        sleeplbl.setBounds(0, 300, 50, 50);
        sleep.setImage(sleep.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        sleeplbl.setVisible(false);
        fightFrame.getContentPane().add(sleeplbl);
        JLabel sleeplblEnemy = new JLabel(sleep);
        sleeplblEnemy.setBounds(1300, 300, 100, 100);
        sleeplblEnemy.setVisible(false);
        fightFrame.getContentPane().add(sleeplblEnemy);

        // show pokemon pictures in fight
        myTeamPokelbl = new JLabel(myTeamPokemon);
        myTeamPokelbl.setBounds(100, 100, 400, 400);
        myTeamPokemon.setImage(myTeamPokemon.getImage().getScaledInstance(325, 325, Image.SCALE_DEFAULT));
        fightFrame.getContentPane().add(myTeamPokelbl);

        enemyTeamPokelbl = new JLabel(enemyTeamPokemon);
        enemyTeamPokelbl.setBounds(800, 100, 400, 400);
        enemyTeamPokemon.setImage(enemyTeamPokemon.getImage().getScaledInstance(325, 325, Image.SCALE_DEFAULT));
        fightFrame.getContentPane().add(enemyTeamPokelbl);

        ImageIcon bgbattle = new ImageIcon(getClass().getResource("/poke/images/BGbattle2.png"));
        JLabel bgbattlelbl = new JLabel(bgbattle);
        bgbattlelbl.setBounds(0, 0, 1400, 868);
        fightFrame.getContentPane().add(bgbattlelbl);

        fightFrame.setVisible(true);

        // BUTTON COMMANDS
        ffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                fightFrame.dispose();
                showDefeatScreen();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                battleNarrationArea.setText("What will " + myTeam.get(0).getName() + " do?");

                atk1Button.setVisible(false);
                atk2Button.setVisible(false);
                atk3Button.setVisible(false);
                atk4Button.setVisible(false);

                fightButton.setVisible(true);
                ffButton.setVisible(true);
                bagButton.setVisible(true);
                switchButton.setVisible(true);

                cancelButton.setVisible(false);
                continueButton.setVisible(false);
            }
        });

        fightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                battleNarrationArea.setText("What move will " + myTeam.get(0).getName() + " use?");
                battleNarration.updateUI();

                fightButton.setVisible(false);
                ffButton.setVisible(false);
                bagButton.setVisible(false);
                switchButton.setVisible(false);

                cancelButton.setVisible(true);
                // continueButton.setVisible(true);

                atk1Button.setText(myTeam.get(0).getATK1().getName() + myTeam.get(0).checkPP(myTeam.get(0).getATK1())
                        + "/" + myTeam.get(0).getATK1().getTotalPP() + "(" + myTeam.get(0).getATK1().getType() + ")");
                atk1Button.setVisible(true);

                atk2Button.setText(myTeam.get(0).getATK2().getName() + myTeam.get(0).checkPP(myTeam.get(0).getATK2())
                        + "/" + myTeam.get(0).getATK2().getTotalPP() + "(" + myTeam.get(0).getATK2().getType() + ")");
                atk2Button.setVisible(true);

                atk3Button.setText(myTeam.get(0).getATK3().getName() + myTeam.get(0).checkPP(myTeam.get(0).getATK3())
                        + "/" + myTeam.get(0).getATK3().getTotalPP() + "(" + myTeam.get(0).getATK3().getType() + ")");
                atk3Button.setVisible(true);

                atk4Button.setText(myTeam.get(0).getATK4().getName() + myTeam.get(0).checkPP(myTeam.get(0).getATK4())
                        + "/" + myTeam.get(0).getATK4().getTotalPP() + "(" + myTeam.get(0).getATK4().getType() + ")");
                atk4Button.setVisible(true);

            }
        });

        bagButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                showBagScreen();
            }
        });

        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                showSwitchScreen();
            }
        });

        atk1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                bm.setAttackSelected(myTeam.get(0).getATK1());
                attack = true;

                continueButton.setVisible(true);

                // battleNarrationArea.setText(myTeam.get(0).getName() + " used " +
                // myTeam.get(0).getATK1().getName());
                battleNarrationArea.setText(displayBattle(myTeam.get(0).getATK1()));
                battleNarrationArea.updateUI();

                myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/"
                        + myTeam.get(0).getTotalHP());
                myTeamInfo.updateUI();

                enemyTeamInfo.setText(enemyTeam.get(0).getName() + "\nHP: " + enemyTeam.get(0).getBattleHP() + "/"
                        + enemyTeam.get(0).getTotalHP());
                enemyTeamInfo.updateUI();

                // switchButton.setEnabled(false);
                // make it so user can only press continue button
                cancelButton.setEnabled(false);
                atk1Button.setEnabled(false);
                atk2Button.setEnabled(false);
                atk3Button.setEnabled(false);
                atk4Button.setEnabled(false);

            }
        });

        // basically a clone of first attack button
        atk2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                bm.setAttackSelected(myTeam.get(0).getATK2());
                attack = true;

                continueButton.setVisible(true);

                // battleNarrationArea.setText(myTeam.get(0).getName() + " used " +
                // myTeam.get(0).getATK1().getName());
                battleNarrationArea.setText(displayBattle(myTeam.get(0).getATK2()));
                battleNarrationArea.updateUI();

                myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/"
                        + myTeam.get(0).getTotalHP());
                myTeamInfo.updateUI();

                enemyTeamInfo.setText(enemyTeam.get(0).getName() + "\nHP: " + enemyTeam.get(0).getBattleHP() + "/"
                        + enemyTeam.get(0).getTotalHP());
                enemyTeamInfo.updateUI();

                // switchButton.setEnabled(false);
                cancelButton.setEnabled(false);
                atk1Button.setEnabled(false);
                atk2Button.setEnabled(false);
                atk3Button.setEnabled(false);
                atk4Button.setEnabled(false);

            }
        });

        atk3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                bm.setAttackSelected(myTeam.get(0).getATK3());
                attack = true;

                continueButton.setVisible(true);

                // battleNarrationArea.setText(myTeam.get(0).getName() + " used " +
                // myTeam.get(0).getATK1().getName());
                battleNarrationArea.setText(displayBattle(myTeam.get(0).getATK3()));
                battleNarrationArea.updateUI();

                myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/"
                        + myTeam.get(0).getTotalHP());
                myTeamInfo.updateUI();

                enemyTeamInfo.setText(enemyTeam.get(0).getName() + "\nHP: " + enemyTeam.get(0).getBattleHP() + "/"
                        + enemyTeam.get(0).getTotalHP());
                enemyTeamInfo.updateUI();

                // switchButton.setEnabled(false);
                cancelButton.setEnabled(false);
                atk1Button.setEnabled(false);
                atk2Button.setEnabled(false);
                atk3Button.setEnabled(false);
                atk4Button.setEnabled(false);

            }
        });

        atk4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                bm.setAttackSelected(myTeam.get(0).getATK4());
                attack = true;

                continueButton.setVisible(true);

                // battleNarrationArea.setText(myTeam.get(0).getName() + " used " +
                // myTeam.get(0).getATK1().getName());
                battleNarrationArea.setText(displayBattle(myTeam.get(0).getATK4()));
                battleNarrationArea.updateUI();

                myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/"
                        + myTeam.get(0).getTotalHP());
                myTeamInfo.updateUI();

                enemyTeamInfo.setText(enemyTeam.get(0).getName() + "\nHP: " + enemyTeam.get(0).getBattleHP() + "/"
                        + enemyTeam.get(0).getTotalHP());
                enemyTeamInfo.updateUI();

                // switchButton.setEnabled(false);
                cancelButton.setEnabled(false);
                atk1Button.setEnabled(false);
                atk2Button.setEnabled(false);
                atk3Button.setEnabled(false);
                atk4Button.setEnabled(false);

            }
        });

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (myTeam.get(0).fainted() && myTeam.get(1).fainted() && myTeam.get(2).fainted()
                        && myTeam.get(3).fainted() && myTeam.get(4).fainted() && myTeam.get(5).fainted()) {
                    fightFrame.dispose();
                    showDefeatScreen();
                } else if (enemyTeam.get(0).fainted() && enemyTeam.get(1).fainted() && enemyTeam.get(2).fainted()
                        && enemyTeam.get(3).fainted() && enemyTeam.get(4).fainted() && enemyTeam.get(5).fainted()) {
                    fightFrame.dispose();
                    showVictoryScreen();

                } else if (myTeam.get(0).fainted()) {
                    showSwitchScreen();
                    battleNarrationArea.setText("What will " + myTeam.get(0).getName() + " do?");
                    battleNarrationArea.updateUI();

                } else if (enemyTeam.get(0).fainted()) {

                    for (Pokemon poke : enemyTeam) {
                        if (!poke.fainted()) {
                            battleNarrationArea.setText(
                                    "Enemy trainer swapped " + enemyTeam.get(0).getName() + " for " + poke.getName());
                            battleNarrationArea.updateUI();

                            Collections.swap(enemyTeam, 0, enemyTeam.indexOf(poke));

                            ImageIcon image = new ImageIcon(
                                    getClass().getResource("/poke/images/" + enemyTeam.get(0).getPokePictureName()));
                            enemyTeamPokelbl.setIcon(image);

                            enemyTeamInfo.setText(enemyTeam.get(0).getName() + "\nHP: " + enemyTeam.get(0).getBattleHP()
                                    + "/" + enemyTeam.get(0).getTotalHP());
                            enemyTeamInfo.updateUI();
                        }
                    }
                } else {
                    battleNarrationArea.setText("What will " + myTeam.get(0).getName() + " do?");
                    battleNarrationArea.updateUI();
                }

                if (myTeam.get(0).getStatus()[0]) {
                    poisonlbl.setVisible(true);
                }
                if (myTeam.get(0).getStatus()[1]) {
                    paralyzelbl.setVisible(true);
                }
                if (myTeam.get(0).getStatus()[2]) {
                    burnlbl.setVisible(true);
                }
                if (myTeam.get(0).getStatus()[3]) {
                    freezelbl.setVisible(true);
                }
                if (myTeam.get(0).getStatus()[4]) {
                    sleeplbl.setVisible(true);
                }
                if (!myTeam.get(0).getStatus()[0]) {
                    poisonlbl.setVisible(false);
                }
                if (!myTeam.get(0).getStatus()[1]) {
                    paralyzelbl.setVisible(false);
                }
                if (!myTeam.get(0).getStatus()[2]) {
                    burnlbl.setVisible(false);
                }
                if (!myTeam.get(0).getStatus()[3]) {
                    freezelbl.setVisible(false);
                }
                if (!myTeam.get(0).getStatus()[4]) {
                    sleeplbl.setVisible(false);
                }

                if (enemyTeam.get(0).getStatus()[0]) {
                    poisonlblEnemy.setVisible(true);
                }
                if (enemyTeam.get(0).getStatus()[1]) {
                    paralyzelblEnemy.setVisible(true);
                }
                if (enemyTeam.get(0).getStatus()[2]) {
                    burnlblEnemy.setVisible(true);
                }
                if (enemyTeam.get(0).getStatus()[3]) {
                    freezelblEnemy.setVisible(true);
                }
                if (enemyTeam.get(0).getStatus()[4]) {
                    sleeplblEnemy.setVisible(true);
                }
                if (!enemyTeam.get(0).getStatus()[0]) {
                    poisonlblEnemy.setVisible(false);
                }
                if (!enemyTeam.get(0).getStatus()[1]) {
                    paralyzelblEnemy.setVisible(false);
                }
                if (!enemyTeam.get(0).getStatus()[2]) {
                    burnlblEnemy.setVisible(false);
                }
                if (!enemyTeam.get(0).getStatus()[3]) {
                    freezelblEnemy.setVisible(false);
                }
                if (!enemyTeam.get(0).getStatus()[4]) {
                    sleeplblEnemy.setVisible(false);
                }

                cancelButton.setEnabled(true);
                atk1Button.setEnabled(true);
                atk2Button.setEnabled(true);
                atk3Button.setEnabled(true);
                atk4Button.setEnabled(true);

                cancelButton.setVisible(false);
                atk1Button.setVisible(false);
                atk2Button.setVisible(false);
                atk3Button.setVisible(false);
                atk4Button.setVisible(false);
                continueButton.setVisible(false);

                switchButton.setVisible(true);
                fightButton.setVisible(true);
                ffButton.setVisible(true);
                bagButton.setVisible(true);
            }
        });

    }

    private void showDefeatScreen() {
        JFrame loseFrame = new JFrame("You have been defeated!");
        loseFrame.setBounds(1266, 868, width, height);
        loseFrame.setLocationRelativeTo(null);
        loseFrame.getContentPane().setLayout(null);
        loseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loseFrame.setFont(new Font("inhalt", Font.PLAIN, fontSize));

        ImageIcon defeatScreen = new ImageIcon(getClass().getResource("/poke/images/defeat.png"));

        JLabel defeatlbl = new JLabel(defeatScreen);
        defeatlbl.setBounds(0, 0, width, height);
        defeatScreen.setImage(defeatScreen.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT));
        loseFrame.getContentPane().add(defeatlbl);

        loseFrame.setVisible(true);
    }

    private void showVictoryScreen() {
        JFrame winFrame = new JFrame("You have defeated the enemy trainer!");
        winFrame.setBounds(1266, 868, width, height);
        winFrame.setLocationRelativeTo(null);
        winFrame.getContentPane().setLayout(null);
        winFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        winFrame.setFont(new Font("inhalt", Font.PLAIN, fontSize));

        ImageIcon winScreen = new ImageIcon(getClass().getResource("/poke/images/victory.jpg"));

        JLabel winlbl = new JLabel(winScreen);
        winlbl.setBounds(0, 0, width, height);
        winScreen.setImage(winScreen.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT));
        winFrame.getContentPane().add(winlbl);

        winFrame.setVisible(true);

    }

    private void showBagScreen() {
        JFrame bagFrame = new JFrame("Inventory");
        bagFrame.setBounds(1266, 868, 800, 800);
        bagFrame.setLocationRelativeTo(null);
        bagFrame.getContentPane().setLayout(null);
        bagFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bagFrame.setFont(new Font("inhalt", Font.PLAIN, fontSize));

        JButton healPotionButton = new JButton();
        ImageIcon healPotionIcon = new ImageIcon(getClass().getResource("/poke/images/heal.png"));
        healPotionButton.setIcon(healPotionIcon);
        healPotionButton.setBounds(100, 100, 100, 100);
        healPotionButton.setVisible(true);
        bagFrame.getContentPane().add(healPotionButton);

        JTextArea healPotionCounter = new JTextArea("x" + bm.getHealPotionCount());
        healPotionCounter.setBounds(200, 150, 50, 50);
        healPotionCounter.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        healPotionCounter.setVisible(true);
        bagFrame.getContentPane().add(healPotionCounter);

        JButton ppRestoreButton = new JButton();
        ImageIcon ppRestoreIcon = new ImageIcon(getClass().getResource("/poke/images/pprestore.png"));
        ppRestoreButton.setIcon(ppRestoreIcon);
        ppRestoreButton.setBounds(100, 300, 100, 100);
        ppRestoreButton.setVisible(true);
        bagFrame.getContentPane().add(ppRestoreButton);

        JTextArea ppRestoreCounter = new JTextArea("x" + bm.getPPRestoreCount());
        ppRestoreCounter.setBounds(200, 350, 50, 50);
        ppRestoreCounter.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        ppRestoreCounter.setVisible(true);
        bagFrame.getContentPane().add(ppRestoreCounter);

        // button commands
        healPotionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                showHealScreen();
                // item = true
                bagFrame.dispose();
            }
        });

        ppRestoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                showRestoreScreen();
                bagFrame.dispose();
            }
        });

        bagFrame.setVisible(true);
    }

    private void showRestoreScreen() {
        JFrame restoreFrame = new JFrame("Select a Move to restore PP");
        restoreFrame.setBounds(1266, 868, 800, 800);
        restoreFrame.setLocationRelativeTo(null);
        restoreFrame.getContentPane().setLayout(null);
        restoreFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        restoreFrame.setFont(new Font("inhalt", Font.PLAIN, fontSize));

        JButton firstMove = new JButton(myTeam.get(0).getATK1().getName() + " "
                + myTeam.get(0).checkPP(myTeam.get(0).getATK1()) + "/" + myTeam.get(0).getATK1().getTotalPP());
        firstMove.setBounds(100, 100, 300, 100);
        firstMove.setHorizontalAlignment(SwingConstants.CENTER);
        firstMove.setFont(new Font("inhalt", Font.PLAIN, fontSize - 5));
        restoreFrame.getContentPane().add(firstMove);
        firstMove.setVisible(true);

        JButton secondMove = new JButton(myTeam.get(0).getATK2().getName() + " "
                + myTeam.get(0).checkPP(myTeam.get(0).getATK2()) + "/" + myTeam.get(0).getATK2().getTotalPP());
        secondMove.setBounds(400, 200, 300, 100);
        secondMove.setHorizontalAlignment(SwingConstants.CENTER);
        secondMove.setFont(new Font("inhalt", Font.PLAIN, fontSize - 5));
        restoreFrame.getContentPane().add(secondMove);
        secondMove.setVisible(true);

        JButton thirdMove = new JButton(myTeam.get(0).getATK3().getName() + " "
                + myTeam.get(0).checkPP(myTeam.get(0).getATK3()) + "/" + myTeam.get(0).getATK3().getTotalPP());
        thirdMove.setBounds(100, 300, 300, 100);
        thirdMove.setHorizontalAlignment(SwingConstants.CENTER);
        thirdMove.setFont(new Font("inhalt", Font.PLAIN, fontSize - 5));
        restoreFrame.getContentPane().add(thirdMove);
        thirdMove.setVisible(true);

        JButton fourMove = new JButton(myTeam.get(0).getATK4().getName() + " "
                + myTeam.get(0).checkPP(myTeam.get(0).getATK4()) + "/" + myTeam.get(0).getATK4().getTotalPP());
        fourMove.setBounds(400, 400, 300, 100);
        fourMove.setHorizontalAlignment(SwingConstants.CENTER);
        fourMove.setFont(new Font("inhalt", Font.PLAIN, fontSize - 5));
        restoreFrame.getContentPane().add(fourMove);
        fourMove.setVisible(true);

        firstMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (Integer.valueOf(bm.getPPRestoreCount()) == 0) {
                    JOptionPane.showMessageDialog(restoreFrame, "You ran out of Ethers!", "No Ethers",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    myTeam.get(0).addPP(myTeam.get(0).getATK1(), 10);
                    battleNarrationArea.setText(displayBattle(null));
                    restoreFrame.dispose();
                }
            }
        });

        secondMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (Integer.valueOf(bm.getPPRestoreCount()) == 0) {
                    JOptionPane.showMessageDialog(restoreFrame, "You ran out of Ethers!", "No Ethers",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    myTeam.get(0).addPP(myTeam.get(0).getATK2(), 10);
                    battleNarrationArea.setText(displayBattle(null));
                    restoreFrame.dispose();
                }
            }
        });

        thirdMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (Integer.valueOf(bm.getPPRestoreCount()) == 0) {
                    JOptionPane.showMessageDialog(restoreFrame, "You ran out of Ethers!", "No Ethers",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    myTeam.get(0).addPP(myTeam.get(0).getATK3(), 10);
                    battleNarrationArea.setText(displayBattle(null));
                    restoreFrame.dispose();
                }
            }
        });

        fourMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (Integer.valueOf(bm.getPPRestoreCount()) == 0) {
                    JOptionPane.showMessageDialog(restoreFrame, "You ran out of Ethers!", "No Ethers",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    myTeam.get(0).addPP(myTeam.get(0).getATK4(), 10);
                    battleNarrationArea.setText(displayBattle(null));
                    restoreFrame.dispose();
                }
            }
        });

        restoreFrame.setVisible(true);
    }

    private void showHealScreen() {
        JFrame healFrame = new JFrame("Select a Pokemon to Heal");
        healFrame.setBounds(1266, 868, 800, 800);
        healFrame.setLocationRelativeTo(null);
        healFrame.getContentPane().setLayout(null);
        healFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        healFrame.setFont(new Font("inhalt", Font.PLAIN, fontSize));

        JButton firstPokemon = new JButton(
                myTeam.get(1).getName() + " HP:" + myTeam.get(1).getBattleHP() + "/" + myTeam.get(1).getTotalHP());
        firstPokemon.setBounds(100, 100, 300, 100);
        firstPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        firstPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize - 5));
        healFrame.getContentPane().add(firstPokemon);
        firstPokemon.setVisible(true);

        JButton secondPokemon = new JButton(
                myTeam.get(2).getName() + " HP:" + myTeam.get(2).getBattleHP() + "/" + myTeam.get(2).getTotalHP());
        secondPokemon.setBounds(400, 200, 300, 100);
        secondPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        secondPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize - 5));
        healFrame.getContentPane().add(secondPokemon);
        secondPokemon.setVisible(true);

        JButton thirdPokemon = new JButton(
                myTeam.get(3).getName() + " HP:" + myTeam.get(3).getBattleHP() + "/" + myTeam.get(3).getTotalHP());
        thirdPokemon.setBounds(100, 300, 300, 100);
        thirdPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        thirdPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize - 5));
        healFrame.getContentPane().add(thirdPokemon);
        thirdPokemon.setVisible(true);

        JButton fourthPokemon = new JButton(
                myTeam.get(4).getName() + " HP:" + myTeam.get(4).getBattleHP() + "/" + myTeam.get(4).getTotalHP());
        fourthPokemon.setBounds(400, 400, 300, 100);
        fourthPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        fourthPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize - 5));
        healFrame.getContentPane().add(fourthPokemon);
        fourthPokemon.setVisible(true);

        JButton fifthPokemon = new JButton(
                myTeam.get(5).getName() + " HP:" + myTeam.get(5).getBattleHP() + "/" + myTeam.get(5).getTotalHP());
        fifthPokemon.setBounds(100, 500, 300, 100);
        fifthPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        fifthPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize - 5));
        healFrame.getContentPane().add(fifthPokemon);
        fifthPokemon.setVisible(true);

        JButton sixthPokemon = new JButton(
                myTeam.get(0).getName() + " HP:" + myTeam.get(0).getBattleHP() + "/" + myTeam.get(0).getTotalHP());
        sixthPokemon.setBounds(400, 600, 300, 100);
        sixthPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        sixthPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize - 5));
        healFrame.getContentPane().add(sixthPokemon);
        sixthPokemon.setVisible(true);

        healFrame.setVisible(true);

        firstPokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (myTeam.get(1).fainted()) {
                    JOptionPane.showMessageDialog(healFrame, "You can't heal this Pokemon!", "Pokemon Fainted!",
                            JOptionPane.WARNING_MESSAGE);

                } else if (Integer.valueOf(bm.getHealPotionCount()) == 0) {
                    JOptionPane.showMessageDialog(healFrame, "You ran out of potions!", "Not enough potions",
                            JOptionPane.WARNING_MESSAGE);

                } else {
                    battleNarrationArea.setText("You healed " + myTeam.get(1).getName());
                    battleNarrationArea.updateUI();

                    myTeam.get(1).gainHP();
                    bm.lowerHealPotion();

                    if (myTeam.get(1).getBattleHP() > myTeam.get(1).getTotalHP()) {
                        myTeam.get(1).resetHP();
                    }

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/"
                            + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    battleNarrationArea.setText(displayBattle(null));

                    healFrame.dispose();
                }
            }
        });

        secondPokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (myTeam.get(2).fainted()) {
                    JOptionPane.showMessageDialog(healFrame, "You can't heal this Pokemon!", "Pokemon Fainted!",
                            JOptionPane.WARNING_MESSAGE);

                } else if (Integer.valueOf(bm.getHealPotionCount()) == 0) {
                    JOptionPane.showMessageDialog(healFrame, "You ran out of potions!", "Not enough potions",
                            JOptionPane.WARNING_MESSAGE);

                } else {
                    battleNarrationArea.setText("You healed " + myTeam.get(2).getName());
                    battleNarrationArea.updateUI();

                    myTeam.get(2).gainHP();
                    bm.lowerHealPotion();

                    if (myTeam.get(2).getBattleHP() > myTeam.get(2).getTotalHP()) {
                        myTeam.get(2).resetHP();
                    }

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/"
                            + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    battleNarrationArea.setText(displayBattle(null));

                    healFrame.dispose();

                }
            }
        });

        thirdPokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (myTeam.get(3).fainted()) {
                    JOptionPane.showMessageDialog(healFrame, "You can't heal this Pokemon!", "Pokemon Fainted!",
                            JOptionPane.WARNING_MESSAGE);

                } else if (Integer.valueOf(bm.getHealPotionCount()) == 0) {
                    JOptionPane.showMessageDialog(healFrame, "You ran out of potions!", "Not enough potions",
                            JOptionPane.WARNING_MESSAGE);

                } else {
                    battleNarrationArea.setText("You healed " + myTeam.get(3).getName());
                    battleNarrationArea.updateUI();

                    myTeam.get(3).gainHP();
                    bm.lowerHealPotion();

                    if (myTeam.get(3).getBattleHP() > myTeam.get(3).getTotalHP()) {
                        myTeam.get(3).resetHP();
                    }

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/"
                            + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    battleNarrationArea.setText(displayBattle(null));

                    healFrame.dispose();
                }
            }
        });

        fourthPokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (myTeam.get(4).fainted()) {
                    JOptionPane.showMessageDialog(healFrame, "You can't heal this Pokemon!", "Pokemon Fainted!",
                            JOptionPane.WARNING_MESSAGE);

                } else if (Integer.valueOf(bm.getHealPotionCount()) == 0) {
                    JOptionPane.showMessageDialog(healFrame, "You ran out of potions!", "Not enough potions",
                            JOptionPane.WARNING_MESSAGE);

                } else {
                    battleNarrationArea.setText("You healed " + myTeam.get(4).getName());
                    battleNarrationArea.updateUI();

                    myTeam.get(4).gainHP();
                    bm.lowerHealPotion();

                    if (myTeam.get(4).getBattleHP() > myTeam.get(4).getTotalHP()) {
                        myTeam.get(4).resetHP();
                    }

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/"
                            + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    battleNarrationArea.setText(displayBattle(null));

                    healFrame.dispose();
                }
            }
        });

        fifthPokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (myTeam.get(5).fainted()) {
                    JOptionPane.showMessageDialog(healFrame, "You can't heal this Pokemon!", "Pokemon Fainted!",
                            JOptionPane.WARNING_MESSAGE);

                } else if (Integer.valueOf(bm.getHealPotionCount()) == 0) {
                    JOptionPane.showMessageDialog(healFrame, "You ran out of potions!", "Not enough potions",
                            JOptionPane.WARNING_MESSAGE);

                } else {
                    battleNarrationArea.setText("You healed " + myTeam.get(5).getName());
                    battleNarrationArea.updateUI();

                    myTeam.get(5).gainHP();
                    bm.lowerHealPotion();

                    if (myTeam.get(5).getBattleHP() > myTeam.get(5).getTotalHP()) {
                        myTeam.get(5).resetHP();
                    }

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/"
                            + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    battleNarrationArea.setText(displayBattle(null));

                    healFrame.dispose();
                }
            }
        });

        sixthPokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (myTeam.get(0).fainted()) {
                    JOptionPane.showMessageDialog(healFrame, "You can't heal this Pokemon!", "Pokemon Fainted!",
                            JOptionPane.WARNING_MESSAGE);

                } else if (Integer.valueOf(bm.getHealPotionCount()) == 0) {
                    JOptionPane.showMessageDialog(healFrame, "You ran out of potions!", "Not enough potions",
                            JOptionPane.WARNING_MESSAGE);

                } else {
                    battleNarrationArea.setText("You healed " + myTeam.get(0).getName());
                    battleNarrationArea.updateUI();

                    myTeam.get(0).gainHP();
                    bm.lowerHealPotion();

                    if (myTeam.get(0).getBattleHP() > myTeam.get(0).getTotalHP()) {
                        myTeam.get(0).resetHP();
                    }

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/"
                            + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    battleNarrationArea.setText(displayBattle(null));

                    healFrame.dispose();
                }
            }
        });

    }

    private String displayBattle(AttackMove atk) {
        String result = "";
        String enemyAction = bm.trainerAI(myTeam.get(0), enemyTeam.get(0), enemyTeam);

        System.out.println(enemyAction);

        switch (enemyAction.substring(0, 4)) {
            case "heal":
                result += "\nEnemy trainer healed " + enemyTeam.get(0).getName();

                enemyTeamInfo.setText(enemyTeam.get(0).getName() + "\nHP: " + enemyTeam.get(0).getBattleHP() + "/"
                        + enemyTeam.get(0).getTotalHP());
                enemyTeamInfo.updateUI();

                if (atk != null) {
                    result += bm.oneSidedFight(myTeam.get(0), enemyTeam.get(0), atk);
                }

                break;
            case "swap":
                String pokeSwap = enemyAction.substring(4);

                for (Pokemon poke : enemyTeam) {
                    if (poke.getName().equals(pokeSwap)) {
                        result += "\nEnemy trainer swapped " + enemyTeam.get(0).getName() + " to " + poke.getName();
                        Collections.swap(enemyTeam, 0, enemyTeam.indexOf(poke));

                        ImageIcon image = new ImageIcon(
                                getClass().getResource("/poke/images/" + poke.getPokePictureName()));
                        enemyTeamPokelbl.setIcon(image);

                        if (atk != null) {
                            result += bm.oneSidedFight(myTeam.get(0), enemyTeam.get(0), atk);
                        }
                    }
                }

                break;
            default:
                AttackMove enemyAttack = null;

                for (AttackMove mov : enemyTeam.get(0).getMoveSet()) {
                    if (mov.getName().equals(enemyAction)) {
                        enemyAttack = mov;
                        break;
                    }
                }

                if (atk != null) {
                    if (myTeam.get(0).getBattleSPD() >= enemyTeam.get(0).getBattleSPD()) {
                        result += bm.battleOrder(myTeam.get(0), atk, enemyTeam.get(0), enemyAttack);
                    } else if (myTeam.get(0).getBattleSPD() < enemyTeam.get(0).getBattleSPD()) {
                        result += bm.battleOrder(enemyTeam.get(0), enemyAttack, myTeam.get(0), atk);
                    }
                } else {
                    result += bm.oneSidedFight(enemyTeam.get(0), myTeam.get(0), enemyAttack);
                }

                break;
        }

        return result;
    }

    private void showSwitchScreen() {
        JFrame switchFrame = new JFrame("Switch out a pokemon");
        switchFrame.setBounds(1266, 868, 800, 800);
        switchFrame.setLocationRelativeTo(null);
        switchFrame.getContentPane().setLayout(null);
        switchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        switchFrame.setFont(new Font("inhalt", Font.PLAIN, fontSize));

        JButton firstPokemon = new JButton(
                myTeam.get(1).getName() + " HP:" + myTeam.get(1).getBattleHP() + "/" + myTeam.get(1).getTotalHP());
        firstPokemon.setBounds(100, 100, 300, 100);
        firstPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        firstPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize - 5));
        switchFrame.getContentPane().add(firstPokemon);
        firstPokemon.setVisible(true);

        JButton secondPokemon = new JButton(
                myTeam.get(2).getName() + " HP:" + myTeam.get(2).getBattleHP() + "/" + myTeam.get(2).getTotalHP());
        secondPokemon.setBounds(400, 200, 300, 100);
        secondPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        secondPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize - 5));
        switchFrame.getContentPane().add(secondPokemon);
        secondPokemon.setVisible(true);

        JButton thirdPokemon = new JButton(
                myTeam.get(3).getName() + " HP:" + myTeam.get(3).getBattleHP() + "/" + myTeam.get(3).getTotalHP());
        thirdPokemon.setBounds(100, 300, 300, 100);
        thirdPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        thirdPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize - 5));
        switchFrame.getContentPane().add(thirdPokemon);
        thirdPokemon.setVisible(true);

        JButton fourthPokemon = new JButton(
                myTeam.get(4).getName() + " HP:" + myTeam.get(4).getBattleHP() + "/" + myTeam.get(4).getTotalHP());
        fourthPokemon.setBounds(400, 400, 300, 100);
        fourthPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        fourthPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize - 5));
        switchFrame.getContentPane().add(fourthPokemon);
        fourthPokemon.setVisible(true);

        JButton fifthPokemon = new JButton(
                myTeam.get(5).getName() + " HP:" + myTeam.get(5).getBattleHP() + "/" + myTeam.get(5).getTotalHP());
        fifthPokemon.setBounds(100, 500, 300, 100);
        fifthPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        fifthPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize - 5));
        switchFrame.getContentPane().add(fifthPokemon);
        fifthPokemon.setVisible(true);

        switchFrame.setVisible(true);

        // COPY THIS FOR OTHER BUTTONS AS WELL
        firstPokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (myTeam.get(1).fainted()) {
                    JOptionPane.showMessageDialog(switchFrame, "You can't switch to this Pokemon!", "Pokemon Fainted!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    battleNarrationArea
                            .setText("You swapped " + myTeam.get(0).getName() + " for " + myTeam.get(1).getName());
                    Collections.swap(myTeam, 0, 1);

                    ImageIcon image = new ImageIcon(
                            getClass().getResource("/poke/images/" + myTeam.get(0).getPokePictureName()));
                    myTeamPokelbl.setIcon(image);

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/"
                            + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    battleNarrationArea.setText(displayBattle(null));

                    switchFrame.dispose();
                }
            }
        });

        secondPokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (myTeam.get(2).fainted()) {
                    JOptionPane.showMessageDialog(switchFrame, "You can't switch to this Pokemon!", "Pokemon Fainted!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    battleNarrationArea
                            .setText("You swapped " + myTeam.get(0).getName() + " for " + myTeam.get(2).getName());
                    Collections.swap(myTeam, 0, 2);

                    ImageIcon image = new ImageIcon(
                            getClass().getResource("/poke/images/" + myTeam.get(0).getPokePictureName()));
                    myTeamPokelbl.setIcon(image);

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/"
                            + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    battleNarrationArea.setText(displayBattle(null));

                    switchFrame.dispose();
                }
            }
        });

        thirdPokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (myTeam.get(3).fainted()) {
                    JOptionPane.showMessageDialog(switchFrame, "You can't switch to this Pokemon!", "Pokemon Fainted!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    battleNarrationArea
                            .setText("You swapped " + myTeam.get(0).getName() + " for " + myTeam.get(3).getName());
                    Collections.swap(myTeam, 0, 3);

                    ImageIcon image = new ImageIcon(
                            getClass().getResource("/poke/images/" + myTeam.get(0).getPokePictureName()));
                    myTeamPokelbl.setIcon(image);

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/"
                            + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    battleNarrationArea.setText(displayBattle(null));

                    switchFrame.dispose();
                }
            }
        });

        fourthPokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (myTeam.get(4).fainted()) {
                    JOptionPane.showMessageDialog(switchFrame, "You can't switch to this Pokemon!", "Pokemon Fainted!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    battleNarrationArea
                            .setText("You swapped " + myTeam.get(0).getName() + " for " + myTeam.get(4).getName());
                    Collections.swap(myTeam, 0, 4);

                    ImageIcon image = new ImageIcon(
                            getClass().getResource("/poke/images/" + myTeam.get(0).getPokePictureName()));
                    myTeamPokelbl.setIcon(image);

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/"
                            + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    battleNarrationArea.setText(displayBattle(null));

                    switchFrame.dispose();
                }
            }
        });

        fifthPokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                if (myTeam.get(5).fainted()) {
                    JOptionPane.showMessageDialog(switchFrame, "You can't switch to this Pokemon!", "Pokemon Fainted!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    battleNarrationArea
                            .setText("You swapped " + myTeam.get(0).getName() + " for " + myTeam.get(5).getName());
                    Collections.swap(myTeam, 0, 5);

                    ImageIcon image = new ImageIcon(
                            getClass().getResource("/poke/images/" + myTeam.get(0).getPokePictureName()));
                    myTeamPokelbl.setIcon(image);

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/"
                            + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    battleNarrationArea.setText(displayBattle(null));

                    switchFrame.dispose();
                }
            }
        });
    }

}