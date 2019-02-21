/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.cluescrolls.clues;

import java.awt.Color;
import java.awt.Graphics2D;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.plugins.cluescrolls.clues.emote.ItemRequirement;
import net.runelite.client.plugins.cluescrolls.clues.emote.SingleItemRequirement;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;

@Getter
@AllArgsConstructor
public class CoordinateClue extends ClueScroll implements TextClueScroll, LocationClueScroll
{
	private String text;
	private WorldPoint location;
	private static final ItemRequirement HAS_SPADE = new SingleItemRequirement(ItemID.SPADE);
	private static final ItemRequirement CLUE1 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_12037);
	private static final ItemRequirement CLUE2 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_12041);
	private static final ItemRequirement CLUE3 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_3592);
	private static final ItemRequirement CLUE4 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_12045);
	private static final ItemRequirement CLUE5 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_7309);
	private static final ItemRequirement CLUE6 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_7311);
	private static final ItemRequirement CLUE7 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_3584);
	private static final ItemRequirement CLUE8 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_7305);
	private static final ItemRequirement CLUE9 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM);
	private static final ItemRequirement CLUE10 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_2821);
	private static final ItemRequirement CLUE11 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_2815);
	private static final ItemRequirement CLUE12 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_2807);
	private static final ItemRequirement CLUE13 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_3582);
	private static final ItemRequirement CLUE14 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_2803);
	private static final ItemRequirement CLUE15 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_3588);
	private static final ItemRequirement CLUE16 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_7315);
	private static final ItemRequirement CLUE17 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_2805);
	private static final ItemRequirement CLUE18 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_12035);
	private static final ItemRequirement CLUE19 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_3594);
    private static final ItemRequirement CLUE20 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_12047);
	private static final ItemRequirement CLUE21 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_2819);
	private static final ItemRequirement CLUE22 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_2817);
	private static final ItemRequirement CLUE23 = new SingleItemRequirement(ItemID.CLUE_SCROLL_MEDIUM_2809);

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Coordinate Clue").build());

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Click the clue scroll along the edge of your world map to see where you should dig.")
			.build());

		if (plugin.getInventoryItems() != null)
		{
			if (CLUE1.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Fenkenstrain's Castle").build());
			}
			if (CLUE2.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Fairy Ring - BKP").build());
			}
			if (CLUE3.fulfilledBy(plugin.getInventoryItems()) || CLUE4.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Slayer Ring - 1 - Gnome Stronghold -> West ").build());
			}
			if (CLUE5.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Fairy Ring - DKP").build());
			}
			if (CLUE6.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Jewelry Box - B - Monastery").build());
			}
			if (CLUE7.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Fairy Ring - BIP").build());
			}
			if (CLUE8.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Jewelry Box - J - Miscellania").build());
			}
			if (CLUE9.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Jewelry Box - P - Dranor Village").build());
			}
			if (CLUE10.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Portal Nexus - 3 - Falador").build());
			}
			if (CLUE11.fulfilledBy(plugin.getInventoryItems()))
		{
			panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
			panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
					.left("Fairy Ring - BLP - Tzhaar Area -> Exit N -> N past Elvarg").build());
		}
			if (CLUE12.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Necklace of Passage - 2 - The Outpost").build());
			}
			if (CLUE13.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Slayer Ring - 2 - Morytania Slayer Tower").build());
			}
			if (CLUE14.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Fairy Ring - CLS").build());
			}
			if (CLUE15.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Jewelry Box - O - Karamja").build());
			}
			if (CLUE16.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Slayer Ring - 3 - Relekka slayer cave").build());
			}
			if (CLUE17.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Brimhaven house").build());
			}
			if (CLUE18.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Fairy Ring -  BIQ -> Magic Carpet - Uzer").build());
			}
			if (CLUE19.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recomended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Royal seed pod").build());
			}
            if (CLUE20.fulfilledBy(plugin.getInventoryItems()))
            {
                panelComponent.getChildren().add(LineComponent.builder().left("Fairy Ring - AKQ -> SE").build());
                panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
                        .left("Royal seed pod").build());
            }
			if (CLUE21.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Fairy Ring - AKQ -> SE").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Fairy Ring - AIQ").build());
			}
			if (CLUE22.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Fairy Ring - AKQ -> SE").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Fairy Ring - CKR").build());
			}
			if (CLUE23.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Fairy Ring - AKQ -> SE").build());
				panelComponent.getChildren().add(LineComponent.builder().leftColor(TITLED_CONTENT_COLOR)
						.left("Spirit tree - 1 - Tree Gnome Village").build());
			}

			if (!HAS_SPADE.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("").build());
				panelComponent.getChildren().add(LineComponent.builder().left("Requires Spade!").leftColor(Color.RED).build());
			}
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), getLocation());

		if (localLocation == null)
		{
			return;
		}

		OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, plugin.getSpadeImage(), Color.ORANGE);
	}
}
