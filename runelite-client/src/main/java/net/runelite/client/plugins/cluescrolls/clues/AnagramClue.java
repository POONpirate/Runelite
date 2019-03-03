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

import com.google.common.collect.ImmutableSet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Set;
import lombok.Getter;
import net.runelite.api.NPC;
import net.runelite.api.ObjectID;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLICKBOX_BORDER_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLICKBOX_FILL_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLICKBOX_HOVER_BORDER_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.IMAGE_Z_OFFSET;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter
public class AnagramClue extends ClueScroll implements TextClueScroll, NpcClueScroll, ObjectClueScroll
{
	private static final Set<AnagramClue> CLUES = ImmutableSet.of(
		new AnagramClue("A BAKER", "Baraek", new WorldPoint(3217, 3434, 0), "Varrock square", "5", "Portal Nexus - 1 - Varrock square"),
		new AnagramClue("A BASIC ANTI POT", "Captain Tobias", new WorldPoint(3026, 3216, 0), "Port Sarim", "6", "Jewelry Box - P - Dranor Village -> West"),
		new AnagramClue("A HEART", "Aretha", new WorldPoint(1814, 3851, 0), "Soul altar", "2", "Fairy Ring - CIS"),
		new AnagramClue("A ZEN SHE", "Zenesha", new WorldPoint(2652, 3295, 0), "Platebody Southern Ardougne centre square", null),
		new AnagramClue("ACE MATCH ELM", "Cam The Camel", new WorldPoint(3300, 3231, 0), "North of the glider in Al Kharid", null),
		new AnagramClue("AHA JAR", "Jaraah", new WorldPoint(3359, 3276, 0), "Duel Arena hospital", "Jewelry Box - 1 - Duel Arena"),
		new AnagramClue("AN PAINT TONIC", "Captain Ninto", new WorldPoint(2865, 9877, 0), "Bar under White Wolf Mountain", null),
		new AnagramClue("ARC O LINE", "Caroline", new WorldPoint(2715, 3302, 0), "North Witchaven next to the row boat", "11", "Quest Cape"),
		new AnagramClue("ARE COL", "Oracle", new WorldPoint(3013, 3501, 0), "Ice Mountain West of Edgeville", "48", "Jewelry Box - B - Monastery"),
		new AnagramClue("ARMCHAIR THE PELT", "Charlie the Tramp", new WorldPoint(3209, 3392, 0), "South entrance of Varrock", "0", "Portal Nexus - 1 - Varrock square"),
		new AnagramClue("ARR! SO I AM A CRUST, AND?", "Ramara du Croissant", new WorldPoint(2339, 3677, 0), "Piscatoris Fishing Colony", null),
		new AnagramClue("AT HERG", "Regath", new WorldPoint(1719, 3723, 0), "General Store, Arceuus, Zeah", "25", null),
		new AnagramClue("A BAS", "Saba", new WorldPoint(2858, 3577, 0), "Death Plateau", "Jewelry Box - 9 - Warrior's Guild"),
		new AnagramClue("AREA CHEF TREK", "Father Aereck", new WorldPoint(3243, 3208, 0), "Lumbridge Church", "19 or 20", "Lumbridge Graveyard"),
		new AnagramClue("BAIL TRIMS", "Brimstail", new WorldPoint(2402, 3419, 0), "West of Stronghold Slayer Cave", "Slayer Ring - 1 - Gnome Stronghold"),
		new AnagramClue("BAKER CLIMB", "Brambickle", new WorldPoint(2783, 3861, 0), "Trollweiss mountain", null),
		new AnagramClue("BLUE GRIM GUIDED", "Lumbridge Guide", new WorldPoint(3232, 3232, 0), "Lumbridge", null),
		new AnagramClue("BY LOOK", "Bolkoy", new WorldPoint(2529, 3162, 0), "Tree Gnome Village general store", "13", null),
		new AnagramClue("CAR IF ICES", "Sacrifice", new WorldPoint(2209, 3056, 0), "Zul-Andra", null),
		new AnagramClue("CAREER IN MOON", "Oneiromancer", new WorldPoint(2150, 3866, 0), "Astral altar", "25", null),
		new AnagramClue("C ON GAME HOC", "Gnome Coach", new WorldPoint(2395, 3486, 0), "Gnome Ball course", "6", null),
		new AnagramClue("COOL NERD", "Old crone", new WorldPoint(3462, 3557, 0), "East of the Slayer Tower", "619", null),
		new AnagramClue("COPPER ORE CRYPTS", "Prospector Percy", new WorldPoint(3061, 3377, 0), "Motherlode Mine", "12", null),
		new AnagramClue("DED WAR", "Edward", new WorldPoint(3284, 3943, 0), "Inside Rogue's Castle", null),
		new AnagramClue("DEKAGRAM", "Dark mage", new WorldPoint(3039, 4835, 0), "Centre of the Abyss", "13", null),
		new AnagramClue("DO SAY MORE", "Doomsayer", new WorldPoint(3230, 3230, 0), "East of Lumbridge Castle", "95", null),
		new AnagramClue("DIM THARN", "Mandrith", new WorldPoint(3182, 3946, 0), "Wilderness Resource Area", "28 or Puzzle box", null),
		new AnagramClue("DR HITMAN", "Mandrith", new WorldPoint(3182, 3946, 0), "Wilderness Resource Area", "28, Light box or Puzzle box", null),
		new AnagramClue("DR WARDEN FUNK", "Drunken Dwarf", new WorldPoint(2913, 10221, 0), "East Side of Keldagrim", "Puzzle box", null),
		new AnagramClue("DRAGONS LAMENT", "Strange Old Man", new WorldPoint(3564, 3288, 0), "Barrows", "40", null),
		new AnagramClue("DT RUN B", "Brundt the Chieftain", new WorldPoint(2658, 3670, 0), "Rellekka, main hall", "4", "Portal Nexus - 6 - Lunar Isle -> Banker"),
		new AnagramClue("DUO PLUG", "Dugopul", new WorldPoint(2803, 2744, 0), "Graveyard on Ape Atoll", null),
		new AnagramClue("EEK ZERO OP", "Zoo keeper", new WorldPoint(2613, 3269, 0), "Ardougne Zoo", "40", "Ardy Cloak - Monastery"),
		new AnagramClue("EL OW", "Lowe", new WorldPoint(3233, 3423, 0), "Varrock archery store", "Portal Nexus - 1 - Varrock square"),
		new AnagramClue("ERR CURE IT", "Recruiter", new WorldPoint(2541, 3305, 0), "West Ardougne centre square", "20", "West Ardy"),
		new AnagramClue("FORLUN", "Runolf", new WorldPoint(2512, 10256, 0), "Miscellania & Etceteria Dungeon", null),
		new AnagramClue("GOBLIN KERN", "King Bolren", new WorldPoint(2541, 3170, 0), "Tree Gnome Village", "Spirit Tree - 1 - Tree Gnome Village"),
		new AnagramClue("GOT A BOY", "Gabooty", new WorldPoint(2790, 3066, 0), "Centre of Tai Bwo Wannai", "11", "Fairy Ring - CKR"),
		new AnagramClue("GULAG RUN", "Uglug Nar", new WorldPoint(2442, 3051, 0), "West of Jiggig", null),
		new AnagramClue("GOBLETS ODD TOES", "Otto Godblessed", new WorldPoint(2501, 3487, 0), "Otto's Grotto", "2", "Jewelry Box - 5 - Barbarian Outpost -> South"),
		new AnagramClue("HALT US", "Luthas", new WorldPoint(2938, 3152, 0), "Banana plantation, Karamja", "33 (or none)", "Jewelry Box - O - Karmaja"),
		new AnagramClue("HE DO POSE. IT IS CULTRRL, MK?", "Riki the sculptor's model", new WorldPoint(2904, 10206, 0), "East Keldagrim, south of kebab seller.", null),
		new AnagramClue("HEORIC", "Eohric", new WorldPoint(2900, 3565, 0), "Top floor of Burthorpe Castle", "36", "Jewelry Box - 4 - Burthorpe"),
		new AnagramClue("HIS PHOR", "Horphis", new WorldPoint(1639, 3812, 0), "Arceuus Library, Zeah", "1", "Fairy Ring - CIS"),
		new AnagramClue("I AM SIR", "Marisi", new WorldPoint(1813, 3488, 0), "Allotment patch, South coast Zeah", "5", "Xeric's Talisman - 2 - Xeric's Glade"),
		new AnagramClue("ICY FE", "Fycie", new WorldPoint(2630, 2997, 0), "East Feldip Hills", null),
		new AnagramClue("I DOOM ICON INN", "Dominic Onion", new WorldPoint(2609, 3116, 0), "Nightmare Zone", "9,500", "Portal Nexus - C - Yanille"),
		new AnagramClue("I EAT ITS CHART HINTS DO U", "Shiratti the Custodian", new WorldPoint(3427, 2927, 0), "North of fountain, Nardah", null),
		new AnagramClue("I EVEN", "Nieve", new WorldPoint(2432, 3422, 0), "The slayer master in Gnome Stronghold", "2", null),
		new AnagramClue("I FAFFY RUN", "Fairy Nuff", new WorldPoint(3201, 3169, 0), "North of the bank in Zanaris", null),
		new AnagramClue("IM N ZEZIM", "Impling", new WorldPoint(2592, 4324, 0), "The Imp inside Puro-Puro", null),
		new AnagramClue("KAY SIR", "Sir Kay", new WorldPoint(2760, 3496, 0), "The courtyard in Camelot Castle", "6", "Portal Nexus - 8 - Camelot"),
		new AnagramClue("LEAKEY", "Kaylee", new WorldPoint(2957, 3370, 0), "Rising Sun Inn in Falador", "18", "Portal Nexus - 3 - Falador"),
		new AnagramClue("LAND DOOMD", "Odd Old Man", new WorldPoint(3359, 3506, 0), "Limestone mine northeast of Varrock", null),
		new AnagramClue("LARK IN DOG", "King Roald", new WorldPoint(3220, 3476, 0), "Ground floor of Varrock castle", "24", "Portal Nexus - 1 - Varrock"),
		new AnagramClue("LOW LAG", "Gallow", new WorldPoint(1805, 3566, 0), "Vinery in the Great Kourend", "12", "Xeric's Talisman - 2 - Xeric's Glade"),
		new AnagramClue("LADDER MEMO GUV", "Guard Vemmeldo", new WorldPoint(2447, 3418, 1), "Gnome Stronghold Bank", "3", null),
		new AnagramClue("MAL IN TAU", "Luminata", new WorldPoint(3508, 3237, 0), "Near Burgh de Rott entrance", null),
		new AnagramClue("ME AM THE CALC", "Cam the Camel", new WorldPoint(3300, 3231, 0), "Outside Duel Arena", null),
		new AnagramClue("MACHETE CLAM", "Cam the Camel", new WorldPoint(3300, 3231, 0), "Outside Duel Arena", "6", null),
		new AnagramClue("ME IF", "Femi", new WorldPoint(2461, 3382, 0), "Gates of Tree Gnome Stronghold", "Slayer Ring - 1 - Stronghold slayer cave"),
		new AnagramClue("MOLD LA RAN", "Old Man Ral", new WorldPoint(3602, 3209, 0), "Meiyerditch", null),
		new AnagramClue("MOTHERBOARD", "Brother Omad", new WorldPoint(2606, 3211, 0), "Monastery south of Ardougne", "129", null),
		new AnagramClue("MUS KIL READER", "Radimus Erkle", new WorldPoint(2726, 3368, 0), "Legends' Guild", null),
		new AnagramClue("MY MANGLE LAL", "Lammy Langle", new WorldPoint(1688, 3540, 0), "Hosidius House spirit tree patch", null),
		new AnagramClue("NO OWNER", "Oronwen", new WorldPoint(1162, 3178, 0), "Lletya Seamstress shop in Lletya", "20", null),
		new AnagramClue("NOD MED", "Edmond", new WorldPoint(2566, 3332, 0), "Behind the most NW house in East Ardougne", "3", "Necklace of Passage - 2 - The Outpost -> East"),
		new AnagramClue("O BIRDZ A ZANY EN PC", "Cap'n Izzy No-Beard", new WorldPoint(2807, 3191, 0), "Brimhaven Agility Arena", "33", null),
		new AnagramClue("OK CO", "Cook", new WorldPoint(3207, 3214, 0), "Ground floor of Lumbridge Castle", "9", "Portal Nexus - 4 - Lumbridge"),
		new AnagramClue("OR ZINC FUMES WARD", "Wizard Frumscone", new WorldPoint(2594, 3086, 0), "Downstairs in the Wizards' Guild", null),
		new AnagramClue("OUR OWN NEEDS", "Nurse Wooned", new WorldPoint(1575, 3590, 0), "Shayzien House Infirmary", "19", null),
		new AnagramClue("PACINNG A TAIE", "Captain Ginea", new WorldPoint(1561, 3602, 0), "Building east of Shayzien combat ring", "113", "Xeric's Talisman - 1 - Xeric's Look-out"),
		new AnagramClue("PEAK REFLEX", "Flax keeper", new WorldPoint(2744, 3444, 0), "Flax field south of Seers Village", "676", "Portal Nexus - 9 - Seers' Village"),
		new AnagramClue("PEATY PERT", "Party Pete", new WorldPoint(3047, 3376, 0), "Falador Party Room", "Jewelry Box - L - Falador Park"),
		new AnagramClue("PROFS LOSE WRONG PIE", "Professor Onglewip", new WorldPoint(3113, 3162, 0), "Ground floor of Wizards Tower", null),
		new AnagramClue("QUIT HORRIBLE TYRANT", "Brother Tranquility", new WorldPoint(3681, 2963, 0), "Mos Le'Harmless or Harmony Island", "7", null),
		new AnagramClue("QUE SIR", "Squire", new WorldPoint(2975, 3343, 0), "Falador Castle Courtyard", "654", "Portal Nexus - 3 - Falador"),
		new AnagramClue("R AK MI", "Karim", new WorldPoint(3273, 3181, 0), "Al Kharid Kebab shop", "5", "Jewelry Box - Q - Al Kharid"),
		new AnagramClue("RAT MAT WITHIN", "Martin Thwait", new WorldPoint(2906, 3537, 0), "Rogues' Den", "2", null),
		new AnagramClue("RED ART TANS", "Trader Stan", new WorldPoint(3041, 3193, 0), "Port Sarim Charter ship", null),
		new AnagramClue("RATAI", "Taria", new WorldPoint(2940, 3223, 0), "Rimmington bush patch", "7", "Jewelry Box - F - Crafting Guild "),
		new AnagramClue("R SLICER", "Clerris", new WorldPoint(1761, 3850, 0), "Arceuus mine, Zeah", "738", "Fairy Ring - CIS"),
		new AnagramClue("SAND NUT", "Dunstan", new WorldPoint(2919, 3574, 0), "Anvil in north east Burthorpe", "8", "Jewelry Box - 4 - Burthorpe"),
		new AnagramClue("SEQUIN DIRGE", "Queen Sigrid", new WorldPoint(2612, 3867, 0), "Throne room of Etceteria Castle.", null),
		new AnagramClue("SLAM DUSTER GRAIL", "Guildmaster Lars", new WorldPoint(1649, 3498, 0), "Woodcutting guild, Zeah", null),
		new AnagramClue("SLIDE WOMAN", "Wise Old Man", new WorldPoint(3088, 3253, 0), "Draynor Village", "28", null),
		new AnagramClue("SNAH", "Hans", new WorldPoint(3218, 3219, 0), "Lumbridge Castle courtyard", null),
		new AnagramClue("SNAKES SO I SAIL", "Lisse Isaakson", new WorldPoint(2351, 3801, 0), "Neitiznot", "2", null),
		new AnagramClue("TAMED ROCKS", "Dockmaster", new WorldPoint(1822, 3739, 0), "Piscarilius House, NE of General store", "5", null),
		new AnagramClue("TEN WIGS ON", "Wingstone", new WorldPoint(3389, 2877, 0), "Between Nardah & Agility Pyramid", null),
		new AnagramClue("THEM CAL CAME", "Cam the Camel", new WorldPoint(3300, 3231, 0), "Just outside of the Duel Arena", null),
		new AnagramClue("THICKNO", "Hickton", new WorldPoint(2822, 3442, 0), "Catherby fletching shop", "2", "Portal Nexus - 8 - Camelot"),
		new AnagramClue("TWENTY CURE IRON", "New recruit Tony", new WorldPoint(1498, 3544, 0), "Shayzien House's Graveyard", null),
		new AnagramClue("UNLEASH NIGHT MIST", "Sigli the Huntsman", new WorldPoint(2660, 3654, 0), "Rellekka", "302", null),
		new AnagramClue("VESTE", "Steve", new WorldPoint(2432, 3423, 0), "Upstairs Wyvern Area or Stronghold Slayer Cave", "2", "Slayer Ring - 1 - Stronghold slayer cave"),
		new AnagramClue("VEIL VEDA", "Evil Dave", new WorldPoint(3079, 9892, 0), "Doris' basement, Edgeville", "666", null),
		new AnagramClue("WOO AN EGG KIWI", "Awowogei", ObjectID.AWOWOGEI, new WorldPoint(2802, 2765, 0), "Ape Atoll", "24", null),
		new AnagramClue("YAWNS GY", "Ysgawyn", new WorldPoint(2340, 3167, 0), "Lletya", null),
		new AnagramClue("MAJORS LAVA BADS AIR", "Ambassador Alvijar", new WorldPoint(2736, 5351, 1), "Dorgesh-Kaan, NE Middle Level", "2505", null)
	);

	private String text;
	private String npc;
	private WorldPoint location;
	private String area;
	private String answer;
	private int objectId;
	private String teleport;

	private AnagramClue(String text, String npc, WorldPoint location, String area, String teleport)
	{
		this(text, npc, location, area, null, teleport);
	}

	private AnagramClue(String text, String npc, WorldPoint location, String area, String answer, String teleport)
	{
		this.text = "This anagram reveals who to speak to next: " + text;
		this.npc = npc;
		this.location = location;
		this.area = area;
		this.answer = answer;
		this.objectId = -1;
		this.teleport = teleport;
	}

	private AnagramClue(String text, String npc, int objectId, WorldPoint location, String area, String answer, String teleport)
	{
		this(text, npc, location, area, answer, teleport);
		this.objectId = objectId;
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Anagram Clue").build());

		if (teleport == null) {
			panelComponent.getChildren().add(LineComponent.builder().left("NPC:").build());
			panelComponent.getChildren().add(LineComponent.builder()
					.left(getNpc())
					.leftColor(TITLED_CONTENT_COLOR)
					.build());

			panelComponent.getChildren().add(LineComponent.builder().left("Area:").build());
			panelComponent.getChildren().add(LineComponent.builder()
					.left(getArea())
					.leftColor(TITLED_CONTENT_COLOR)
					.build());
		}

		if (getAnswer() != null)
		{
			panelComponent.getChildren().add(LineComponent.builder().left("Answer:").build());
			panelComponent.getChildren().add(LineComponent.builder()
				.left(getAnswer())
				.leftColor(TITLED_CONTENT_COLOR)
				.build());
		}

			if (teleport != null)
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Recommended tele:").build());
				panelComponent.getChildren().add(LineComponent.builder()
						.leftColor(TITLED_CONTENT_COLOR)
						.left(teleport)
						.build());
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		if (!getLocation().isInScene(plugin.getClient()))
		{
			return;
		}

		// Mark NPC
		if (objectId == -1 && plugin.getNpcsToMark() != null)
		{
			for (NPC npc : plugin.getNpcsToMark())
			{
				OverlayUtil.renderActorOverlayImage(graphics, npc, plugin.getClueScrollImage(), Color.ORANGE, IMAGE_Z_OFFSET);
			}
		}

		// Mark game object
		if (objectId != -1)
		{
			net.runelite.api.Point mousePosition = plugin.getClient().getMouseCanvasPosition();

			for (TileObject gameObject : plugin.getObjectsToMark())
			{
				OverlayUtil.renderHoverableArea(graphics, gameObject.getClickbox(), mousePosition,
					CLICKBOX_FILL_COLOR, CLICKBOX_BORDER_COLOR, CLICKBOX_HOVER_BORDER_COLOR);

				OverlayUtil.renderImageLocation(plugin.getClient(), graphics, gameObject.getLocalLocation(), plugin.getClueScrollImage(), IMAGE_Z_OFFSET);
			}
		}
	}

	public static AnagramClue forText(String text)
	{
		for (AnagramClue clue : CLUES)
		{
			if (clue.text.equalsIgnoreCase(text))
			{
				return clue;
			}
		}

		return null;
	}

	public String[] getNpcs()
	{
		return new String[] {npc};
	}

	public int[] getObjectIds()
	{
		return new int[] {objectId};
	}
}
