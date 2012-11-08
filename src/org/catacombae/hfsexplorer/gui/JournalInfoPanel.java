/*-
 * Copyright (C) 2007 Erik Larsson
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.catacombae.hfsexplorer.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.catacombae.hfs.Journal;
import org.catacombae.hfs.types.hfsplus.JournalInfoBlock;

public class JournalInfoPanel extends JPanel {
    private JPanel contentsPanel;
    private JournalInfoBlockPanel infoBlockPanel;
    private JPanel noJournalPanel;
    private JLabel noJournalLabel;
    private CardLayout layout;

    public JournalInfoPanel(Journal journal) {
	contentsPanel = new JPanel();
	infoBlockPanel = new JournalInfoBlockPanel();
	noJournalPanel = new JPanel();
	noJournalLabel = new JLabel("No journal present", SwingConstants.CENTER);
	layout = new CardLayout();

	contentsPanel.setLayout(new BorderLayout());
	contentsPanel.add(infoBlockPanel, BorderLayout.CENTER);

	noJournalPanel.setLayout(new BorderLayout());
	noJournalPanel.add(noJournalLabel, BorderLayout.CENTER);

	setLayout(layout);
	add(noJournalPanel, "A");
	add(contentsPanel, "B");
	layout.show(this, "A");

	//pack();
        setFields(journal);
    }

    public void setFields(Journal journal) {
        infoBlockPanel.setFields(journal.getJournalInfoBlock());
	layout.show(this, "B");
    }
}
